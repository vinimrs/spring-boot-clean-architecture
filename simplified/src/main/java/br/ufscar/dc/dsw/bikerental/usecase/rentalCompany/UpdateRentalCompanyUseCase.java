package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyUpdateData;

// @Service
public class UpdateRentalCompanyUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public UpdateRentalCompanyUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(Long id, IRentalCompanyUpdateData dados) throws RentalCompanyNotFoundException {
        RentalCompany rentalCompany = this.rentalCompanyGateway.findById(id)
                .orElseThrow(RentalCompanyNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            rentalCompany.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            rentalCompany.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            rentalCompany.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            rentalCompany.setEmail(dados.email());

        if(dados.cnpj() != null && !dados.cnpj().isBlank())
            rentalCompany.setCnpj(dados.cnpj());

        if(dados.city() != null && !dados.city().isBlank())
            rentalCompany.setCity(dados.city());

        return this.rentalCompanyGateway.update(rentalCompany);
    }

}
