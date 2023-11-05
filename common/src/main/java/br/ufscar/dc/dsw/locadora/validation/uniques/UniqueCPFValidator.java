package br.ufscar.dc.dsw.locadora.validation.uniques;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.repository.IClienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

  @Autowired
  private IClienteRepository repository;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
    if (repository != null) {
      Cliente cliente = repository.findByCpf(CPF);
      return cliente == null;
    } else {
      // Durante a execução da classe LocadoraMVC
      // não há injeção de dependência
    }
    return true;
  }
}