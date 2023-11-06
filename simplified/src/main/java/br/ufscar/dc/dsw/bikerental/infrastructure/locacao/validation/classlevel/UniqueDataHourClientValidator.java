package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.validation.classlevel;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.LocacaoSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourClientValidator implements ConstraintValidator<ValidLocacao, Rental> {

  @Autowired
  private LocacaoRepository repository;

  @Override
  public boolean isValid(Rental rental, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      List<LocacaoSchema> locacoes = repository.findAllByClient(new ClienteSchema(rental.getClient()));

      if (locacoes == null) {
        return true;
      }

      locacoes.forEach(locacao1 -> {
        if (locacao1.getDate().equals(rental.getDate()) && locacao1.getHour().equals(rental.getHour())) {
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