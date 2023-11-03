package br.ufscar.dc.dsw.locadora.usecase.locacao;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

import java.util.List;

// @Service
public class ListLocacoesByLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;
    private final LocacaoGateway locacaoGateway;

    public ListLocacoesByLocadoraUseCase(LocacaoGateway locacaoGateway, LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
        this.locacaoGateway = locacaoGateway;
    }

    public List<Locacao> execute(Long rentalCompanyId) throws LocadoraNotFoundException, LocacaoNotFoundException {

        Locadora locadora = this.locadoraGateway.findById(rentalCompanyId)
                .orElseThrow(LocadoraNotFoundException::new);

        return this.locacaoGateway.findAllByRentalCompany(locadora);
    }

}
