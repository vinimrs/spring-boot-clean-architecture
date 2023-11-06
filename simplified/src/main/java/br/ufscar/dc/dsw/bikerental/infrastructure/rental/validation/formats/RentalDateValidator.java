package br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RentalDateValidator implements ConstraintValidator<RentalDate, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // We ignore whether the field is null in update requests

    try {
      LocalDate date = LocalDate.parse(fieldValue, RentalDate.formatter);
      return date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now());
    } catch (Exception e) {
      return false;
    }
  }
}