package br.ufscar.dc.dsw.locadora.validation.formats.locacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.format.DateTimeFormatter;

@Constraint(validatedBy = LocacaoDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LocacaoDate {
  String message() default "Input a valid date.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
