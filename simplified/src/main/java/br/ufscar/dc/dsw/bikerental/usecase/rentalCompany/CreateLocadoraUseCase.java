package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosCadastroLocadora;

// @Service
public class CreateLocadoraUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public CreateLocadoraUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(IDadosCadastroLocadora dados) {

        RentalCompany rentalCompany = new RentalCompany(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cnpj(), dados.city());

        return this.rentalCompanyGateway.create(rentalCompany);
    }


}
