package br.ufscar.dc.dsw.bikerental.repository;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
  Customer findByCpf(String cpf);

  Collection<Customer> findAllByCpf(String cpf);
}
