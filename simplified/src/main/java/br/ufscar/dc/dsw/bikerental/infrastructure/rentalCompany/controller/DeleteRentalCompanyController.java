package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.DeleteRentalCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteRentalCompanyController {

    private final DeleteRentalCompanyUseCase deleteRentalCompanyUseCase;

    public DeleteRentalCompanyController(DeleteRentalCompanyUseCase deleteRentalCompanyUseCase) {
        this.deleteRentalCompanyUseCase = deleteRentalCompanyUseCase;
    }

    @DeleteMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalCompanyPublicData deleteRentalCompany(@PathVariable Long id) throws RentalCompanyNotFoundException {
        return new RentalCompanyPublicData(deleteRentalCompanyUseCase.execute(id));
    }

}
