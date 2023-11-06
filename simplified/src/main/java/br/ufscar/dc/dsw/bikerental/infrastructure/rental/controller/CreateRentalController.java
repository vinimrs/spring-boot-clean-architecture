package br.ufscar.dc.dsw.bikerental.infrastructure.rental.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalRegistrationData;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.CreateRentalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRentalController {

    private final CreateRentalUseCase createRentalUseCase;

    public CreateRentalController(CreateRentalUseCase createRentalUseCase) {
        this.createRentalUseCase = createRentalUseCase;
    }

    @PostMapping("/rentals")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalPublicData createRental(@Valid @RequestBody RentalRegistrationData dados) throws CustomerrNotFoundException, RentalCompanyNotFoundException {
        return new RentalPublicData(createRentalUseCase.execute(dados));
    }

}
