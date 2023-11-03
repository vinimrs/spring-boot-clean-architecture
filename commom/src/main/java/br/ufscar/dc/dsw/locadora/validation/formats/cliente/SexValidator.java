package br.ufscar.dc.dsw.locadora.validation.formats.cliente;

import br.ufscar.dc.dsw.locadora.domain.Sexo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SexValidator implements ConstraintValidator<Sex, String> {

  @Override
  public boolean isValid(String sex, ConstraintValidatorContext context) {
    if (sex == null || sex.isBlank()) return true; // Ignoramos se o campo é nulo em requisições de atualização

    try {
      Sexo.valueOf(sex);
    } catch (IllegalArgumentException e) {
      return false;
    }

    return true;
  }
}