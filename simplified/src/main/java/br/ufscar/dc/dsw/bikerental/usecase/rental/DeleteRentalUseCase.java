package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;

// @Service
public class DeleteRentalUseCase {
    private final RentalGateway rentalGateway;

    public DeleteRentalUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(Long id) throws RentalNotFoundException {
        Rental rental = rentalGateway.findById(id)
            .orElseThrow(RentalNotFoundException::new);

        rentalGateway.delete(id);

        return rental;
    }

}
