package br.ufscar.dc.dsw.bikerental.infrastructure.rental.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.GetRentalUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRentalController {

    private final GetRentalUseCase getRentalUseCase;

    public GetRentalController(GetRentalUseCase getRentalUseCase) {
        this.getRentalUseCase = getRentalUseCase;
    }

    @GetMapping("/rentals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalPublicData getRental(@PathVariable Long id) throws RentalNotFoundException {
        Rental rental = getRentalUseCase.execute(id);

        return new RentalPublicData(rental);
    }

}
