package br.ufscar.dc.dsw.bikerental.validation.classlevel;

import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.repository.IRentalRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourCustomerValidator implements ConstraintValidator<ValidRental, Rental> {

  @Autowired
  private IRentalRepository repository;

  @Override
  public boolean isValid(Rental rental, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      List<Rental> locacoes = repository.findAllByCustomer(rental.getCustomer());
      locacoes.forEach(rentalEl -> {
        if (rentalEl.getDate().equals(rental.getDate()) && rentalEl.getHour().equals(rental.getHour())) {
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