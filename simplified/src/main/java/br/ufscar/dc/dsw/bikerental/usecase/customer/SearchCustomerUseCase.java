package br.ufscar.dc.dsw.bikerental.usecase.customer;

import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;

import java.util.List;

// @Service
public class SearchCustomerUseCase {
    private final CustomerGateway customerGateway;

    public SearchCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public List<Customer> execute() {
        return this.customerGateway.findAll();
    }


}
