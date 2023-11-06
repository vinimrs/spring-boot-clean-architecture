package br.ufscar.dc.dsw.bikerental.infrastructure.customer.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CostumerUpdateData;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.customer.UpdateCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateCustomerController {

    private final UpdateCustomerUseCase updateCustomerUseCase;

    public UpdateCustomerController(UpdateCustomerUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData createCustomer(@PathVariable Long id, @Valid @RequestBody CostumerUpdateData dados) throws CustomerrNotFoundException {
        return new CustomerPublicData(updateCustomerUseCase.execute(id, dados));
    }

}
