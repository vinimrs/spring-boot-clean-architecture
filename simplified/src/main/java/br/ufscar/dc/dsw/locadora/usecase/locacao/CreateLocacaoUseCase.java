package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosCadastroLocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateLocacaoUseCase {
    private final ClienteGateway clienteGateway;
    private final LocadoraGateway locadoraGateway;
    private final LocacaoGateway locacaoGateway;

    public CreateLocacaoUseCase(LocacaoGateway locacaoGateway, LocadoraGateway locadoraGateway, ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
        this.locadoraGateway = locadoraGateway;
        this.locacaoGateway = locacaoGateway;
    }

    public Locacao execute(IDadosCadastroLocacao dados) throws ClienteNotFoundException, LocadoraNotFoundException {

        Cliente cliente = this.clienteGateway.findById(dados.clientId())
                .orElseThrow(ClienteNotFoundException::new);

        Locadora locadora = this.locadoraGateway.findById(dados.rentalCompanyId())
                .orElseThrow(LocadoraNotFoundException::new);

        Locacao locacao = new Locacao(LocalTime.parse(dados.hour(), DateTimeFormatter.ofPattern("HH:00")),
                                        LocalDate.parse(dados.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                        locadora,
                                        cliente);

        return this.locacaoGateway.create(locacao);
    }


}
