package br.ufscar.dc.dsw.bikerental.infrastructure.customer.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.customer.GetCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetCustomerController {

    private final GetCustomerUseCase getCustomerUseCase;

    public GetCustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerPublicData getCustomer(@PathVariable Long id) throws CustomerrNotFoundException {
        Customer customer = getCustomerUseCase.execute(id);

        return new CustomerPublicData(customer);
    }

}
