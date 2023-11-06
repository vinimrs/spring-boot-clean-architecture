package br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RentalHourValidator implements ConstraintValidator<RentalHour, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // We ignore whether the field is null in update requests

    try {
      LocalTime date = LocalTime.parse(fieldValue, RentalHour.formatter);
      return date.isAfter(LocalTime.now());
    } catch (Exception e) {
      return false;
    }
  }
}