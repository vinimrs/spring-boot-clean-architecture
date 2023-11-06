package br.ufscar.dc.dsw.bikerental.entity.customer.gateway;


import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(Long id);

    Optional<Customer> findById(Long id);
    Optional<Customer> findByCpf(String cpf);

    List<Customer> findAll();
}
