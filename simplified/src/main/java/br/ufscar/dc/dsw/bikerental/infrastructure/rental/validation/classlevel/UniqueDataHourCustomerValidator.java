package br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.classlevel;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourCustomerValidator implements ConstraintValidator<ValidRentalData, Rental> {

  @Autowired
  private RentalRepository repository;

  @Override
  public boolean isValid(Rental rental, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      List<RentalSchema> rentals = repository.findAllByCustomer(new CustomerSchema(rental.getCustomer()));

      if (rentals == null) {
        return true;
      }

      rentals.forEach(rentalEl -> {
        if (rentalEl.getDate().equals(rental.getDate()) && rentalEl.getHour().equals(rental.getHour())) {
          isValid[0] = false;
        }
      });

      if (!isValid[0]) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("hour").addConstraintViolation();
      }

      return isValid[0];
    } else {
      return true;
    }
  }
}