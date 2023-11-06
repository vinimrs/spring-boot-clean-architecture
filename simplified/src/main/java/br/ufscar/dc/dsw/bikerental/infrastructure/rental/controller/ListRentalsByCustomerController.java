package br.ufscar.dc.dsw.bikerental.infrastructure.rental.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto.RentalPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.ListRentalsByCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRentalsByCustomerController {

    private final ListRentalsByCustomerUseCase listRentalsByCustomerUseCase;

    public ListRentalsByCustomerController(ListRentalsByCustomerUseCase listRentalsByCustomerUseCase) {
        this.listRentalsByCustomerUseCase = listRentalsByCustomerUseCase;
    }

    @GetMapping("/rentals/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalPublicData> listRentalsByCustomer(@PathVariable Long customerId) throws RentalNotFoundException, CustomerrNotFoundException {
        List<Rental> rentals = this.listRentalsByCustomerUseCase.execute(customerId);

        return rentals.stream().map(RentalPublicData::new).toList();
    }

}
