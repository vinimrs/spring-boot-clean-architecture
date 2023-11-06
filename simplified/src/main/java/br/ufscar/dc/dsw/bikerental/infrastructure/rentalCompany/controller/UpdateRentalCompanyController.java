package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyUpdateData;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.UpdateRentalCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateRentalCompanyController {

    private final UpdateRentalCompanyUseCase updateRentalCompanyUseCase;

    public UpdateRentalCompanyController(UpdateRentalCompanyUseCase updateRentalCompanyUseCase) {
        this.updateRentalCompanyUseCase = updateRentalCompanyUseCase;
    }

    @PutMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalCompanyPublicData updateRentalCompany(@PathVariable Long id, @Valid @RequestBody RentalCompanyUpdateData dados) throws RentalCompanyNotFoundException {
        return new RentalCompanyPublicData(updateRentalCompanyUseCase.execute(id, dados));
    }

}
