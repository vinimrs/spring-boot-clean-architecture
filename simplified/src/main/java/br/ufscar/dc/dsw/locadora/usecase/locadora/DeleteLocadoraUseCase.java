package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

// @Service
public class DeleteLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;

    public DeleteLocadoraUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public Locadora execute(Long id) throws LocadoraNotFoundException {
        Locadora locadora = locadoraGateway.findById(id)
            .orElseThrow(LocadoraNotFoundException::new);

        locadoraGateway.delete(id);

        return locadora;
    }

}
