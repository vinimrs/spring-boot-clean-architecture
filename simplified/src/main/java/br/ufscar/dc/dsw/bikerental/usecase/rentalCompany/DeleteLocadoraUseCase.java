package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

// @Service
public class DeleteLocadoraUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public DeleteLocadoraUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(Long id) throws RentalCompanyNotFoundException {
        RentalCompany rentalCompany = rentalCompanyGateway.findById(id)
            .orElseThrow(RentalCompanyNotFoundException::new);

        rentalCompanyGateway.delete(id);

        return rentalCompany;
    }

}
