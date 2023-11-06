package br.ufscar.dc.dsw.bikerental.usecase.customer;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Sex;
import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerUpdateData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class UpdateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public UpdateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Long id, ICustomerUpdateData dados) throws CustomerrNotFoundException {
        Customer customer = this.customerGateway.findById(id)
                .orElseThrow(CustomerrNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            customer.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            customer.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            customer.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            customer.setEmail(dados.email());

        if(dados.cpf() != null && !dados.cpf().isBlank())
            customer.setCpf(dados.cpf());

        if(dados.phoneNumber() != null && !dados.phoneNumber().isBlank())
            customer.setPhoneNumber(dados.phoneNumber());

        if(dados.sex() != null && !dados.sex().isBlank())
            customer.setSex(Sex.valueOf(dados.sex()));

        if(dados.birthdate() != null && !dados.birthdate().isBlank())
            customer.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));


        return this.customerGateway.update(customer);
    }

}
