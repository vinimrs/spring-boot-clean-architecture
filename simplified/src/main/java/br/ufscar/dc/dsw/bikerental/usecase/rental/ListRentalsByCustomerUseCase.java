package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;

import java.util.List;

// @Service
public class ListRentalsByCustomerUseCase {
    private final CustomerGateway customerGateway;
    private final RentalGateway rentalGateway;

    public ListRentalsByCustomerUseCase(RentalGateway rentalGateway, CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute(Long customerId) throws RentalNotFoundException, CustomerrNotFoundException {

        Customer customer = this.customerGateway.findById(customerId)
                .orElseThrow(CustomerrNotFoundException::new);

        return this.rentalGateway.findAllByCustomer(customer);
    }

}
