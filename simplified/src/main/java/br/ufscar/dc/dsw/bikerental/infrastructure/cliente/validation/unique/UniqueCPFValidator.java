package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.unique;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.ClienteSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

  @Autowired
  private ClienteRepository repository;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<ClienteSchema> cliente = repository.findByCpf(CPF);
      return cliente.isEmpty();
    } else {
      // Durante a execução da classe LocadoraMVC
      // não há injeção de dependência
    }
    return true;
  }
}