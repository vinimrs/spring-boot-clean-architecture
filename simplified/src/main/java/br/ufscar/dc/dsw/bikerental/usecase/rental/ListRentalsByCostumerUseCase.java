package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;

import java.util.List;

// @Service
public class ListRentalsByCostumerUseCase {
    private final CostumerGateway costumerGateway;
    private final RentalGateway rentalGateway;

    public ListRentalsByCostumerUseCase(RentalGateway rentalGateway, CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute(Long clientId) throws RentalNotFoundException, CostumerNotFoundException {

        Costumer costumer = this.costumerGateway.findById(clientId)
                .orElseThrow(CostumerNotFoundException::new);

        return this.rentalGateway.findAllByClient(costumer);
    }

}
