package br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class NameValidator implements ConstraintValidator<Name, String> {

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    /*
     * ^ - start of string
     * [a-zA-Z]{4,} - 4 or more ASCII letters
     * (?: [a-zA-Z]+){0,2} - 0 to 2 occurrences of a space followed with one or more ASCII letters
     * $ - end of string.
     */
    if (name == null || name.isBlank()) return true; // We ignore whether the field is null in update requests


    return name.matches("^[a-zA-Zà-úÀ-Ú]{3,}(?: [a-zA-Zà-úÀ-Ú]+){1,}$");
  }
}