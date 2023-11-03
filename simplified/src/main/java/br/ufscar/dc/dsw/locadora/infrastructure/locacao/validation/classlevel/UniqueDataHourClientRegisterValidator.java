package br.ufscar.dc.dsw.locadora.infrastructure.locacao.validation.classlevel;

import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocacaoSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosCadastroLocacao;
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
public class UniqueDataHourClientRegisterValidator implements ConstraintValidator<ValidCadastroLocacao, DadosCadastroLocacao> {

  @Autowired
  private LocacaoRepository repository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public boolean isValid(DadosCadastroLocacao locacao, ConstraintValidatorContext context) {

    if (repository != null) {
      AtomicBoolean isValid = new AtomicBoolean(true);

      ClienteSchema cliente = clienteRepository.getReferenceById(locacao.clientId());

      List<LocacaoSchema> locacoes = repository.findAllByClient(cliente);

      if (locacoes == null) {
        return true;
      }

      locacoes.forEach(locacao1 -> {
        System.out.println("locacao1.getDate(): " + locacao1.getDate());
        if (locacao1.getDate().equals(LocalDate.parse(locacao.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            && locacao1.getHour().equals(LocalTime.parse(locacao.hour(), DateTimeFormatter.ofPattern("HH:00")))) {
          isValid.set(false);
        }
      });

      // Se a validação falhar, o método isValid retorna false
      if (!isValid.get()) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("hour").addConstraintViolation();
      }

      return isValid.get();
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }
  }
}