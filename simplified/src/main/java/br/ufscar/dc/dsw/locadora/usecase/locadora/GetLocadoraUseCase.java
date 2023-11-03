package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

// @Service
public class GetLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;

    public GetLocadoraUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public Locadora execute(Long id) throws LocadoraNotFoundException {
        return this.locadoraGateway
                .findById(id)
                .orElseThrow(LocadoraNotFoundException::new);
    }

}
