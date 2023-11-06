package br.ufscar.dc.dsw.bikerental.infrastructure.rental.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.ListRentalsByRentalCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRentalsByRentalCompanyController {

    private final ListRentalsByRentalCompanyUseCase listRentalsUseCase;

    public ListRentalsByRentalCompanyController(ListRentalsByRentalCompanyUseCase listRentalsUseCase) {
        this.listRentalsUseCase = listRentalsUseCase;
    }

    @GetMapping("/rentals/rentalCompanies/{rentalCompanyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalPublicData> searchRentalsByRentalCompany(@PathVariable Long rentalCompanyId) throws RentalNotFoundException,
            RentalCompanyNotFoundException {
        List<Rental> rentals = this.listRentalsUseCase.execute(rentalCompanyId);

        return rentals.stream().map(RentalPublicData::new).toList();
    }

}
