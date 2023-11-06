package br.ufscar.dc.dsw.bikerental.service.impl;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalRegistrationData;
import br.ufscar.dc.dsw.bikerental.repository.ICustomerRepository;
import br.ufscar.dc.dsw.bikerental.repository.IRentalRepository;
import br.ufscar.dc.dsw.bikerental.repository.IRentalCompanyRepository;
import br.ufscar.dc.dsw.bikerental.service.spec.IRentalService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = false)
public class RentalService implements IRentalService {

  @Autowired
  private Validator validator;

  @Autowired
  private IRentalRepository repository;

  @Autowired
  private IRentalCompanyRepository rentalCompanyRepository;

  @Autowired
  private ICustomerRepository customerRepository;

  @Transactional(readOnly = true)
  public Rental findById(Long id) {
    Rental rental = repository.findById(id).orElse(null);

    if (rental == null) {
      throw new EntityNotFoundException();
    }

    return rental;
  }

  @Transactional(readOnly = true)
  public Page<Rental> findAllByRentalCompany(Pageable pageable, RentalCompany rentalCompany) {
    return repository.findAllByRentalCompany(rentalCompany, pageable);
  }

  @Transactional(readOnly = true)
  public Page<Rental> findAllByCustomer(Pageable pageable, Customer customer) {
    return repository.findAllByCustomer(customer, pageable);
  }

  @Transactional(readOnly = true)
  public Page<Rental> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Rental save(RentalRegistrationData rental) {
    RentalCompany rentalCompany = rentalCompanyRepository.findById(rental.rentalCompanyId()).orElse(null);
    Customer customer = customerRepository.findById(rental.customerId()).orElse(null);

    if (rentalCompany == null || customer == null) {
      throw new EntityNotFoundException();
    }

    Rental newRental = new Rental(rental, rentalCompany, customer);

    Set<ConstraintViolation<Rental>> violations = validator.validate(newRental);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(newRental);
    return newRental;
  }

  @Override
  public Rental delete(Long id) {
    Rental rental = repository.findById(id).orElse(null);

    if (rental == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return rental;
  }

  @Override
  public Page<Rental> findAllByLocadora(Long id, Pageable pageable) {
    RentalCompany rentalCompany = rentalCompanyRepository.findById(id).orElse(null);

    if (rentalCompany == null) {
      throw new EntityNotFoundException();
    }

    return repository.findAllByRentalCompany(rentalCompany, pageable);
  }

  @Override
  public Page<Rental> findAllByCustomer(Long id, Pageable pageable) {
    Customer customer = customerRepository.findById(id).orElse(null);

    if (customer == null) {
      throw new EntityNotFoundException();
    }

    return repository.findAllByCustomer(customer, pageable);
  }
}
