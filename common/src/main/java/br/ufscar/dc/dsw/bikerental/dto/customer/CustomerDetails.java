package br.ufscar.dc.dsw.bikerental.dto.customer;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.domain.Sex;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalDetailsCustomes;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record CustomerDetails(
    Long id, String username, String name, String email,
    String cpf, String phoneNumber, Sex sex,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthdate,
    List<RentalDetailsCustomes> locacoes) {
  public CustomerDetails(Customer customer) {
    this(customer.getId(), customer.getUsername(), customer.getName(), customer.getEmail(),
        customer.getCpf(), customer.getPhoneNumber(), customer.getSex(), customer.getBirthdate(),
        customer.getLocacoes() != null ? customer.getLocacoes().stream().map(RentalDetailsCustomes::new).toList() : List.of());
  }

}
