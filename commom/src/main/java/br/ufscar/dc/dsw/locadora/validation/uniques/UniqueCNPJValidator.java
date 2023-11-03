package br.ufscar.dc.dsw.locadora.validation.uniques;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.repository.ILocadoraRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private ILocadoraRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      Locadora locadora = repository.findByCnpj(CNPJ);
      return locadora == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }

  }
}