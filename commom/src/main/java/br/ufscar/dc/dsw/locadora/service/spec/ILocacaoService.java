package br.ufscar.dc.dsw.locadora.service.spec;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosCadastroLocacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILocacaoService {

  Locacao findById(Long id);

  Page<Locacao> findAllByRentalCompany(Pageable pageable, Locadora rentalCompany);

  Page<Locacao> findAllByClient(Pageable pageable, Cliente client);

  Page<Locacao> findAll(Pageable pageable);

  Locacao save(DadosCadastroLocacao locacao);

  Locacao delete(Long id);

  Page<Locacao> findAllByLocadora(Long id, Pageable pageable);

  Page<Locacao> findAllByCliente(Long id, Pageable pageable);
}
