package br.ufscar.dc.dsw.bikerental.infrastructure.customer.controller;

import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerRegistrationData;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.customer.CreateCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CreateCustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerPublicData createCustomer(@Valid @RequestBody CustomerRegistrationData dados) {
        return new CustomerPublicData(createCustomerUseCase.execute(dados));
    }

}
