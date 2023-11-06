package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosAtualizacaoLocadora;

// @Service
public class UpdateLocadoraUseCase {
    private final RentalCompanyGateway rentalCompanyGateway;

    public UpdateLocadoraUseCase(RentalCompanyGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public RentalCompany execute(Long id, IDadosAtualizacaoLocadora dados) throws RentalCompanyNotFoundException {
        RentalCompany cliente = this.rentalCompanyGateway.findById(id)
                .orElseThrow(RentalCompanyNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            cliente.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            cliente.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            cliente.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            cliente.setEmail(dados.email());

        if(dados.cnpj() != null && !dados.cnpj().isBlank())
            cliente.setCnpj(dados.cnpj());

        if(dados.city() != null && !dados.city().isBlank())
            cliente.setCity(dados.city());

        return this.rentalCompanyGateway.update(cliente);
    }

}
