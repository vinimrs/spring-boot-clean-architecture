package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CNPJValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CNPJ {
  String message() default "Input a valid cpf.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
