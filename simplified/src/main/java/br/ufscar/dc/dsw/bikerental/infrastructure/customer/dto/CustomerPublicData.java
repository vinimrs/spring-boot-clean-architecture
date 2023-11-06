package br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto;

import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerPublicData;

public record CustomerPublicData(
        String id,

        String username,

        String name,

        String email,

        String phoneNumber
) implements ICustomerPublicData {
        public CustomerPublicData(Customer customer) {
                this(
                        customer.getId().toString(),
                        customer.getUsername(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhoneNumber()
                );
        }
}