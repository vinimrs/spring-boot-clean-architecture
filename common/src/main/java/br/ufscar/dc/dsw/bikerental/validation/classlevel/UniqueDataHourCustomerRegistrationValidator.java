package br.ufscar.dc.dsw.bikerental.validation.classlevel;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalRegistrationData;
import br.ufscar.dc.dsw.bikerental.repository.ICustomerRepository;
import br.ufscar.dc.dsw.bikerental.repository.IRentalRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourCustomerRegistrationValidator implements ConstraintValidator<ValidRentalRegistration, RentalRegistrationData> {

  @Autowired
  private IRentalRepository repository;

  @Autowired
  private ICustomerRepository customerRepository;

  @Override
  public boolean isValid(RentalRegistrationData rental, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      Customer customer = customerRepository.getReferenceById(rental.customerId());
      List<Rental> locacoes = repository.findAllByCustomer(customer);
      locacoes.forEach(rental1 -> {
        if (rental1.getDate().equals(rental.date()) && rental1.getHour().equals(rental.hour())) {
          isValid[0] = false;
        }
      });

      // Se a validação falhar, o método isValid retorna false
      if (!isValid[0]) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("hour").addConstraintViolation();
      }

      return isValid[0];
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }
  }
}