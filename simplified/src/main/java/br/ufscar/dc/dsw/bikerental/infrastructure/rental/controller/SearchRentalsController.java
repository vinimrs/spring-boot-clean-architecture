package br.ufscar.dc.dsw.bikerental.infrastructure.rental.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.SearchRentalsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchRentalsController {

    private final SearchRentalsUseCase searchRentalsUseCase;

    public SearchRentalsController(SearchRentalsUseCase searchRentalsUseCase) {
        this.searchRentalsUseCase = searchRentalsUseCase;
    }

    @GetMapping("/rentals")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalPublicData> searchRentals() {
        List<Rental> rentals = this.searchRentalsUseCase.execute();

        return rentals.stream().map(RentalPublicData::new).toList();
    }

}
