package br.ufscar.dc.dsw.bikerental.validation.formats.rental;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RentalHourValidator implements ConstraintValidator<RentalHour, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // Ignoramos se o campo é nulo em requisições de atualização

    try {
      LocalTime date = LocalTime.parse(fieldValue, RentalHour.formatter);
      return date.isAfter(LocalTime.now());
    } catch (Exception e) {
      return false;
    }
  }
}