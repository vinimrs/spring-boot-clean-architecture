package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;

// @Service
public class FindRentalCompaniesByCityUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public FindRentalCompaniesByCityUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public List<RentalCompany> execute(String city) {

        return this.rentalCompanyGateway.findAllByCity(city);
    }

}
