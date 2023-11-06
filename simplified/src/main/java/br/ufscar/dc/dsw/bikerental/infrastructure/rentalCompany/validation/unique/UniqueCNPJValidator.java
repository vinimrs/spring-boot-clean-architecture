package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.unique;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalCompanyRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalCompanySchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private RentalCompanyRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<RentalCompanySchema> rentalCompany = repository.findByCnpj(CNPJ);
      return rentalCompany.isEmpty();
    }

    return true;
  }
}