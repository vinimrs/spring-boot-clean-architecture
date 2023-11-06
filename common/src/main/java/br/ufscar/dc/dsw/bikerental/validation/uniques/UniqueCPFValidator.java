package br.ufscar.dc.dsw.bikerental.validation.uniques;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.repository.ICustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

  @Autowired
  private ICustomerRepository repository;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
    if (repository != null) {
      Customer customer = repository.findByCpf(CPF);
      return customer == null;
    } else {
      // Durante a execução da classe LocadoraMVC
      // não há injeção de dependência
    }
    return true;
  }
}