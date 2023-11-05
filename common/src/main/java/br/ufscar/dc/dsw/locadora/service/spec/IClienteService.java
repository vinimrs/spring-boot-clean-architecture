package br.ufscar.dc.dsw.locadora.service.spec;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosCadastroCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService {

  Cliente findById(Long id);

  Page<Cliente> findAll(Pageable pageable);

  Cliente save(DadosCadastroCliente cliente);

  Cliente delete(Long id);

  Cliente update(Long id, DadosAtualizacaoCliente dados);
}
