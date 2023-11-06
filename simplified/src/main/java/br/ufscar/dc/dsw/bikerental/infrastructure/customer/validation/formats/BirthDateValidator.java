package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

  @Override
  public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
    if (birthDate == null) return true;

    LocalDate today = LocalDate.now();
    return birthDate.isBefore(today);
  }
}