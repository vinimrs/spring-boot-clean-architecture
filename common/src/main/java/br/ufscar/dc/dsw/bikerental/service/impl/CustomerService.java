package br.ufscar.dc.dsw.bikerental.service.impl;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.dto.customer.CUstomerUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.customer.CustomerRegistrationData;
import br.ufscar.dc.dsw.bikerental.repository.ICustomerRepository;
import br.ufscar.dc.dsw.bikerental.repository.IUserRepository;
import br.ufscar.dc.dsw.bikerental.service.spec.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class CustomerService implements ICustomerService {

  @Autowired
  private Validator validator;

  @Autowired
  private ICustomerRepository repository;

  @Autowired
  private IUserRepository usuarioRepository;

  public Customer save(CustomerRegistrationData dados) {
    Customer customer = new Customer(dados);

    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(customer);
    return customer;
  }

  public Customer delete(Long id) {
    Customer customer = repository.findById(id).orElse(null);

    if (customer == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return customer;
  }

  @Transactional(readOnly = true)
  public Customer update(Long id, CUstomerUpdateData dados) {
    Customer customer = repository.findById(id).orElse(null);

    if (customer == null) {
      throw new EntityNotFoundException();
    }

    if (dados.email() != null && !dados.email().equals(customer.getEmail())) {
      int quantidadeEmail = usuarioRepository.findAllByEmail(dados.email()).size();
      if (quantidadeEmail > 0) {
        throw new ConstraintViolationException("Email já cadastrado", Set.of(
            validator.validateProperty(customer, "email").iterator().next()
        ));
      }
    }

    if (dados.username() != null && !dados.username().equals(customer.getUsername())) {
      int quantidadeUsername = usuarioRepository.findAllByUsername(dados.username()).size();
      if (quantidadeUsername > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(customer, "username").iterator().next())
        );
      }
    }

    if (dados.cpf() != null && !dados.cpf().equals(customer.getCpf())) {
      int quantidadeCpf = repository.findAllByCpf(dados.cpf()).size();
      if (quantidadeCpf > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(customer, "cpf").iterator().next())
        );
      }
    }

    customer.atualizar(dados);

    return customer;
  }

  @Transactional(readOnly = true)
  public Customer findById(Long id) {
    Customer customer = repository.findById(id).orElse(null);

    if (customer == null) {
      throw new EntityNotFoundException();
    }

    return customer;
  }

  @Transactional(readOnly = true)
  public Page<Customer> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
