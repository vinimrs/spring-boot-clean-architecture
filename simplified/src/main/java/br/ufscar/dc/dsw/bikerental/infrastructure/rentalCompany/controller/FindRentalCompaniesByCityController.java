package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.FindRentalCompaniesByCityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindRentalCompaniesByCityController {

    private final FindRentalCompaniesByCityUseCase findRentalCompaniesByCityUseCase;

    public FindRentalCompaniesByCityController(FindRentalCompaniesByCityUseCase findRentalCompaniesByCityUseCase) {
        this.findRentalCompaniesByCityUseCase = findRentalCompaniesByCityUseCase;
    }

    @GetMapping("/rentalCompanies/cidades/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalCompanyPublicData> findRentalCompaniesByCity(@PathVariable String city) {
        List<RentalCompany> rentalCompanies = this.findRentalCompaniesByCityUseCase.execute(city);

        return rentalCompanies.stream().map(RentalCompanyPublicData::new).toList();
    }

}
