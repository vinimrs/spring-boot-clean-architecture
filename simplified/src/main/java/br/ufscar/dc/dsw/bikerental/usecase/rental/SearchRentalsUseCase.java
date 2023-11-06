package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;

import java.util.List;

// @Service
public class SearchRentalsUseCase {
    private final RentalGateway rentalGateway;

    public SearchRentalsUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute() {
        return this.rentalGateway.findAll();
    }


}
