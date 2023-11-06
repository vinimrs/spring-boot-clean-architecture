package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BirthDateFieldValidator implements ConstraintValidator<BirthDateField, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // We ignore whether the field is null in update requests

    try {
      LocalDate birthDate = LocalDate.parse(fieldValue, BirthDateField.formatter);
      LocalDate today = LocalDate.now();
      return birthDate.isBefore(today);
    } catch (Exception e) {
      return false;
    }
  }
}