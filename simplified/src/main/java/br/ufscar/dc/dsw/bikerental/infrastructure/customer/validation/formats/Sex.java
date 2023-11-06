package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SexValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sex {
  String message() default "Input a valid sex.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
