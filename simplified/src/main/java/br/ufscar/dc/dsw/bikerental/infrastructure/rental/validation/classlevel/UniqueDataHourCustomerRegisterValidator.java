package br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.classlevel;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.CustomerRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalRegistrationData;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class UniqueDataHourCustomerRegisterValidator implements ConstraintValidator<ValidRentalRegistrationData, RentalRegistrationData> {

  @Autowired
  private RentalRepository repository;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public boolean isValid(RentalRegistrationData rental, ConstraintValidatorContext context) {

    if (repository != null) {
      AtomicBoolean isValid = new AtomicBoolean(true);

      CustomerSchema customer = customerRepository.getReferenceById(rental.customerId());

      List<RentalSchema> rentals = repository.findAllByCustomer(customer);

      if (rentals == null) {
        return true;
      }

      rentals.forEach(rental1 -> {
        System.out.println("rental1.getDate(): " + rental1.getDate());
        if (rental1.getDate().equals(LocalDate.parse(rental.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            && rental1.getHour().equals(LocalTime.parse(rental.hour(), DateTimeFormatter.ofPattern("HH:00")))) {
          isValid.set(false);
        }
      });

      if (!isValid.get()) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("hour").addConstraintViolation();
      }

      return isValid.get();
    } else {
      return true;
    }
  }
}