package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;

// @Service
public class SearchLocadoraUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public SearchLocadoraUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public List<RentalCompany> execute() {
        return this.rentalCompanyGateway.findAll();
    }


}
