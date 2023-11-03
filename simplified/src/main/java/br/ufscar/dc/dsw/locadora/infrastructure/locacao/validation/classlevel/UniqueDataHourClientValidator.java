package br.ufscar.dc.dsw.locadora.infrastructure.locacao.validation.classlevel;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocacaoSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourClientValidator implements ConstraintValidator<ValidLocacao, Locacao> {

  @Autowired
  private LocacaoRepository repository;

  @Override
  public boolean isValid(Locacao locacao, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      List<LocacaoSchema> locacoes = repository.findAllByClient(new ClienteSchema(locacao.getClient()));

      if (locacoes == null) {
        return true;
      }

      locacoes.forEach(locacao1 -> {
        if (locacao1.getDate().equals(locacao.getDate()) && locacao1.getHour().equals(locacao.getHour())) {
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