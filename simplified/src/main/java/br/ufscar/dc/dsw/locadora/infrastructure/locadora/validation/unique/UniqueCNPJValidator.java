package br.ufscar.dc.dsw.locadora.infrastructure.locadora.validation.unique;

import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocadoraRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private LocadoraRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<LocadoraSchema> locadora = repository.findByCnpj(CNPJ);
      return locadora.isEmpty();
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }

  }
}