package br.ufscar.dc.dsw.bikerental.dto.customer;

import br.ufscar.dc.dsw.bikerental.domain.Customer;

public record CustomerPublicData(
    Long id, String username, String name, String email, String phoneNumber) {
  public CustomerPublicData(Customer customer) {
    this(customer.getId(), customer.getUsername(), customer.getName(), customer.getEmail(), customer.getPhoneNumber());
  }

}
