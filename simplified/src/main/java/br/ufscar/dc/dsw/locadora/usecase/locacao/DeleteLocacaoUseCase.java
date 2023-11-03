package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;

// @Service
public class DeleteLocacaoUseCase {
    private final LocacaoGateway locacaoGateway;

    public DeleteLocacaoUseCase(LocacaoGateway locacaoGateway) {
        this.locacaoGateway = locacaoGateway;
    }

    public Locacao execute(Long id) throws LocacaoNotFoundException {
        Locacao locacao = locacaoGateway.findById(id)
            .orElseThrow(LocacaoNotFoundException::new);

        locacaoGateway.delete(id);

        return locacao;
    }

}
