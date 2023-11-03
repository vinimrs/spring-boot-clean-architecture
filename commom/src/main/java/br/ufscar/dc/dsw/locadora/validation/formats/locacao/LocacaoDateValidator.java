package br.ufscar.dc.dsw.locadora.validation.formats.locacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocacaoDateValidator implements ConstraintValidator<LocacaoDate, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // Ignoramos se o campo é nulo em requisições de atualização

    try {
      LocalDate date = LocalDate.parse(fieldValue, LocacaoDate.formatter);
      return date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now());
    } catch (Exception e) {
      return false;
    }
  }
}