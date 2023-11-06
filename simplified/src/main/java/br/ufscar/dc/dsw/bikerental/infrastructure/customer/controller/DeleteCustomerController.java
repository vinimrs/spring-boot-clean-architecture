package br.ufscar.dc.dsw.bikerental.infrastructure.customer.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.customer.DeleteCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteCustomerController {

    private final DeleteCustomerUseCase deleteCustomerUseCase;

    public DeleteCustomerController(DeleteCustomerUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData deleteCustomer(@PathVariable Long id) throws CustomerrNotFoundException {
        return new CustomerPublicData(deleteCustomerUseCase.execute(id));
    }

}
