package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyRegistrationData;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.CreateRentalCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRentalCompanyController {

    private final CreateRentalCompanyUseCase createRentalCompanyUseCase;

    public CreateRentalCompanyController(CreateRentalCompanyUseCase createRentalCompanyUseCase) {
        this.createRentalCompanyUseCase = createRentalCompanyUseCase;
    }

    @PostMapping("/rentalCompanies")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalCompanyPublicData createRentalCompany(@Valid @RequestBody RentalCompanyRegistrationData dados) {
        return new RentalCompanyPublicData(createRentalCompanyUseCase.execute(dados));
    }

}
