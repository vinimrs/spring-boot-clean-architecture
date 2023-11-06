package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;

// @Service
public class GetRentalUseCase {
    private final RentalGateway rentalGateway;

    public GetRentalUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(Long id) throws RentalNotFoundException {
        return this.rentalGateway
                .findById(id)
                .orElseThrow(RentalNotFoundException::new);
    }

}
