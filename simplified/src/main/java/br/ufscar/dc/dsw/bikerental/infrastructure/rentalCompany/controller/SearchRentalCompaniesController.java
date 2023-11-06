package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.SearchRentalCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchRentalCompaniesController {

    private final SearchRentalCompanyUseCase searchRentalCompanyUseCase;

    public SearchRentalCompaniesController(SearchRentalCompanyUseCase searchRentalCompanyUseCase) {
        this.searchRentalCompanyUseCase = searchRentalCompanyUseCase;
    }

    @GetMapping("/rentalCompanies")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalCompanyPublicData> searchRentalCompanies() {
        List<RentalCompany> rentalCompanies = this.searchRentalCompanyUseCase.execute();

        return rentalCompanies.stream().map(RentalCompanyPublicData::new).toList();
    }

}
