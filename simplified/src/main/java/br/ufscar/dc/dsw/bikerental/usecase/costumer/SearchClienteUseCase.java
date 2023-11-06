package br.ufscar.dc.dsw.bikerental.usecase.costumer;

import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;

import java.util.List;

// @Service
public class SearchClienteUseCase {
    private final CostumerGateway costumerGateway;

    public SearchClienteUseCase(CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
    }

    public List<Costumer> execute() {
        return this.costumerGateway.findAll();
    }


}
