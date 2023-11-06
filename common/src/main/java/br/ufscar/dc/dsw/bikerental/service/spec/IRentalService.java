package br.ufscar.dc.dsw.bikerental.service.spec;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRentalService {

  Rental findById(Long id);

  Page<Rental> findAllByRentalCompany(Pageable pageable, RentalCompany rentalCompany);

  Page<Rental> findAllByCustomer(Pageable pageable, Customer customer);

  Page<Rental> findAll(Pageable pageable);

  Rental save(RentalRegistrationData rental);

  Rental delete(Long id);

  Page<Rental> findAllByLocadora(Long id, Pageable pageable);

  Page<Rental> findAllByCustomer(Long id, Pageable pageable);
}
