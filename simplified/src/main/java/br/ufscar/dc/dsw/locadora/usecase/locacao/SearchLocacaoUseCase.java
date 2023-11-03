package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;

import java.util.List;

// @Service
public class SearchLocacaoUseCase {
    private final LocacaoGateway locacaoGateway;

    public SearchLocacaoUseCase(LocacaoGateway locacaoGateway) {
        this.locacaoGateway = locacaoGateway;
    }

    public List<Locacao> execute() {
        return this.locacaoGateway.findAll();
    }


}
