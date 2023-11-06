package br.ufscar.dc.dsw.bikerental.usecase.customer;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;

// @Service
public class DeleteCustomerUseCase {
    private final CustomerGateway customerGateway;

    public DeleteCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Long id) throws CustomerrNotFoundException {
        Customer customer = customerGateway.findById(id)
            .orElseThrow(CustomerrNotFoundException::new);

        customerGateway.delete(id);

        return customer;
    }

}
