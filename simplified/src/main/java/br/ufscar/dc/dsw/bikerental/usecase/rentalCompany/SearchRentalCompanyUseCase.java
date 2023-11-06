package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;

// @Service
public class SearchRentalCompanyUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public SearchRentalCompanyUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public List<RentalCompany> execute() {
        return this.rentalCompanyGateway.findAll();
    }


}
