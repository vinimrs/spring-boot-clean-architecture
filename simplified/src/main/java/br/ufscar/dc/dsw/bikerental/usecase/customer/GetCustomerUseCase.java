package br.ufscar.dc.dsw.bikerental.usecase.customer;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;

// @Service
public class GetCustomerUseCase {
    private final CustomerGateway customerGateway;

    public GetCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Long id) throws CustomerrNotFoundException {
        return this.customerGateway
                .findById(id)
                .orElseThrow(CustomerrNotFoundException::new);
    }

}
