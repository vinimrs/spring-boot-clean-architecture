package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyRegistrationData;

// @Service
public class CreateRentalCompanyUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public CreateRentalCompanyUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(IRentalCompanyRegistrationData dados) {

        RentalCompany rentalCompany = new RentalCompany(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cnpj(), dados.city());

        return this.rentalCompanyGateway.create(rentalCompany);
    }


}
