package br.ufscar.dc.dsw.bikerental.usecase.rental.dto;

import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerPublicData;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalDetailsRentalCompany {

    Long id();

    LocalTime hour();

    LocalDate date();

    ICustomerPublicData customer();

}
