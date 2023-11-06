package br.ufscar.dc.dsw.bikerental.usecase.costumer;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;

// @Service
public class GetClienteUseCase {
    private final CostumerGateway costumerGateway;

    public GetClienteUseCase(CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
    }

    public Costumer execute(Long id) throws CostumerNotFoundException {
        return this.costumerGateway
                .findById(id)
                .orElseThrow(CostumerNotFoundException::new);
    }

}
