package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.unique;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCNPJValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCNPJ {
  String message() default "CNPJ is already registered";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
