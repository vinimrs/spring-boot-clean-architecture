package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.unique;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCPFValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCPF {
  String message() default "CPF is already registered";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
