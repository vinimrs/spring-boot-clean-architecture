package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosPublicosLocacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

// @Service
public class ListLocacoesByClienteUseCase {
    private final ClienteGateway clienteGateway;
    private final LocacaoGateway locacaoGateway;

    public ListLocacoesByClienteUseCase(LocacaoGateway locacaoGateway, ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
        this.locacaoGateway = locacaoGateway;
    }

    public List<Locacao> execute(Long clientId) throws LocacaoNotFoundException, ClienteNotFoundException {

        Cliente cliente = this.clienteGateway.findById(clientId)
                .orElseThrow(ClienteNotFoundException::new);

        return this.locacaoGateway.findAllByClient(cliente);
    }

}
