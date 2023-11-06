package br.ufscar.dc.dsw.bikerental.infrastructure.customer.gateway;

import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.CustomerRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;

import java.util.List;
import java.util.Optional;

public class CustomerDatabaseGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    public CustomerDatabaseGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository
                .findById(id)
                .map(CustomerSchema::toCustomer);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return customerRepository
                .findByCpf(cpf)
                .map(CustomerSchema::toCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerSchema::toCustomer)
                .toList();
    }
}
