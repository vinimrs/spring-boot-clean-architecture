package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

import java.util.List;

// @Service
public class SearchLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;

    public SearchLocadoraUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public List<Locadora> execute() {
        return this.locadoraGateway.findAll();
    }


}
