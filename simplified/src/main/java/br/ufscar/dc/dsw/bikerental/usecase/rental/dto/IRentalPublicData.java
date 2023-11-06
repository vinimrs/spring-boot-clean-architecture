package br.ufscar.dc.dsw.bikerental.usecase.rental.dto;

import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyPublicData;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalPublicData {

    Long id();

    LocalTime hour();

    LocalDate date();

    IRentalCompanyPublicData rentalCompany();

    ICustomerPublicData customer();

}
