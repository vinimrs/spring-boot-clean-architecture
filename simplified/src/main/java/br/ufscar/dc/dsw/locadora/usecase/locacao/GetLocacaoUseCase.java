package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;

// @Service
public class GetLocacaoUseCase {
    private final LocacaoGateway locacaoGateway;

    public GetLocacaoUseCase(LocacaoGateway locacaoGateway) {
        this.locacaoGateway = locacaoGateway;
    }

    public Locacao execute(Long id) throws LocacaoNotFoundException {
        return this.locacaoGateway
                .findById(id)
                .orElseThrow(LocacaoNotFoundException::new);
    }

}
