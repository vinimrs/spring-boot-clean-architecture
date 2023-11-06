package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;

// @Service
public class ListRentalsByRentalCompanyUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;
    private final RentalGateway rentalGateway;

    public ListRentalsByRentalCompanyUseCase(RentalGateway rentalGateway, RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute(Long rentalCompanyId) throws RentalCompanyNotFoundException, RentalNotFoundException {

        RentalCompany rentalCompany = this.rentalCompanyGateway.findById(rentalCompanyId)
                .orElseThrow(RentalCompanyNotFoundException::new);

        return this.rentalGateway.findAllByRentalCompany(rentalCompany);
    }

}
