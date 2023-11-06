package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.GetRentalCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRentalCompanyController {

    private final GetRentalCompanyUseCase getRentalCompanyUseCase;

    public GetRentalCompanyController(GetRentalCompanyUseCase getRentalCompanyUseCase) {
        this.getRentalCompanyUseCase = getRentalCompanyUseCase;
    }

    @GetMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalCompanyPublicData getRentalCompany(@PathVariable Long id) throws RentalCompanyNotFoundException {
        RentalCompany rentalCompany = getRentalCompanyUseCase.execute(id);

        return new RentalCompanyPublicData(rentalCompany);
    }

}
