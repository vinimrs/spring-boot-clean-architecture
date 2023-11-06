package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CPFValidator implements ConstraintValidator<CPF, String> {

  @Override
  public boolean isValid(String cpf, ConstraintValidatorContext context) {
    if (cpf == null || cpf.isBlank())
      return true; // Ignoramos se o campo é nulo em requisições de atualização

    /*
     * [0-9]{2} Faixa de caracteres: 0 a 9, quantidade: 2 caracteres;
     * [0-9]{3} Faixa de caracteres: 0 a 9, quantidade: 3 caracteres;
     * [0-9]{4} Faixa de caracteres: 0 a 9, quantidade: 4 caracteres;
     * [\.]?Um ponto, opcional. Foi usado \ no ponto, pois ele sozinho é caractere especial;
     * [-]? Um traço, opcional (se acrescentar outros caracteres, comece pelo - sempre);
     * [\/]? Uma barra, opcional. Tambem "escapada" com \ pra agradar o PCRE;
     * (grupo1)|(grupo2) Se um dos grupos validar, a expressão é válida.
     */
    return cpf.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
  }
}