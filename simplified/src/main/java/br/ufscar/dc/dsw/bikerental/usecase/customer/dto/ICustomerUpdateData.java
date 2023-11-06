package br.ufscar.dc.dsw.bikerental.usecase.customer.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface ICustomerUpdateData {

    String username();

    String password();

    String name();

    String email();

    String cpf();

    String phoneNumber();

    String sex();

    String birthdate();
}
