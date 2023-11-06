package br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.unique;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.CustomerRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

  @Autowired
  private CustomerRepository repository;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<CustomerSchema> customer = repository.findByCpf(CPF);
      return customer.isEmpty();
    }

    return true;
  }
}