package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

// @Service
public class GetRentalCompanyUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public GetRentalCompanyUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(Long id) throws RentalCompanyNotFoundException {
        return this.rentalCompanyGateway
                .findById(id)
                .orElseThrow(RentalCompanyNotFoundException::new);
    }

}
