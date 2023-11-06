package br.ufscar.dc.dsw.bikerental.entity.rental.gateway;


import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;
import java.util.Optional;

public interface RentalGateway {
    Rental create(Rental rental);
    void delete(Long id);

    Optional<Rental> findById(Long id);

    List<Rental> findAllByRentalCompany(RentalCompany rentalCompany);

    List<Rental> findAllByCustomer(Customer customer);

    List<Rental> findAll();
}
