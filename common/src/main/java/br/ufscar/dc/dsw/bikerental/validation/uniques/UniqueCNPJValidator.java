package br.ufscar.dc.dsw.bikerental.validation.uniques;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.repository.IRentalCompanyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private IRentalCompanyRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      RentalCompany rentalCompany = repository.findByCnpj(CNPJ);
      return rentalCompany == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }

  }
}