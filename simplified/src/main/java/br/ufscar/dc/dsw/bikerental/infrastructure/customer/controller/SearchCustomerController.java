package br.ufscar.dc.dsw.bikerental.infrastructure.customer.controller;

import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.customer.SearchCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchCustomerController {

    private final SearchCustomerUseCase searchCustomerUseCase;

    public SearchCustomerController(SearchCustomerUseCase searchCustomerUseCase) {
        this.searchCustomerUseCase = searchCustomerUseCase;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerPublicData> searchCustomers() {
        List<Customer> customers = this.searchCustomerUseCase.execute();

        return customers.stream().map(CustomerPublicData::new).toList();
    }

}
