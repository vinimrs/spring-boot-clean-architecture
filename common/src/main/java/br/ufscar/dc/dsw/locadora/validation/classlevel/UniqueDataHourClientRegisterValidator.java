package br.ufscar.dc.dsw.locadora.validation.classlevel;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosCadastroLocacao;
import br.ufscar.dc.dsw.locadora.repository.IClienteRepository;
import br.ufscar.dc.dsw.locadora.repository.ILocacaoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniqueDataHourClientRegisterValidator implements ConstraintValidator<ValidCadastroLocacao, DadosCadastroLocacao> {

  @Autowired
  private ILocacaoRepository repository;

  @Autowired
  private IClienteRepository clienteRepository;

  @Override
  public boolean isValid(DadosCadastroLocacao locacao, ConstraintValidatorContext context) {
    if (repository != null) {

      final boolean[] isValid = {true};

      Cliente cliente = clienteRepository.getReferenceById(locacao.clientId());
      List<Locacao> locacoes = repository.findAllByClient(cliente);
      locacoes.forEach(locacao1 -> {
        if (locacao1.getDate().equals(locacao.date()) && locacao1.getHour().equals(locacao.hour())) {
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