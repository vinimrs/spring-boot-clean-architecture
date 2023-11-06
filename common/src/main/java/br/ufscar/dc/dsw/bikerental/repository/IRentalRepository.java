package br.ufscar.dc.dsw.bikerental.repository;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentalRepository extends JpaRepository<Rental, Long> {
  Page<Rental> findAllByRentalCompany(RentalCompany rentalCompany, Pageable pageable);

  Page<Rental> findAllByCustomer(Customer customer, Pageable pageable);

  List<Rental> findAllByCustomer(Customer customer);
}
