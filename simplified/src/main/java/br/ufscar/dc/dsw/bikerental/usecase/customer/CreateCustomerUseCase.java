package br.ufscar.dc.dsw.bikerental.usecase.customer;

import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Sex;
import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerRegistrationData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(ICustomerRegistrationData dados) {

        Customer customer = new Customer(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cpf(), dados.phoneNumber(), Sex.valueOf(dados.sex()),
            LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return this.customerGateway.create(customer);
    }


}
