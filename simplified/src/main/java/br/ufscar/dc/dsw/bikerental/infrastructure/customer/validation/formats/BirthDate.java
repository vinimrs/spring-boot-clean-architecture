package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BirthDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDate {
  String message() default "Input a valid birthdate.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
