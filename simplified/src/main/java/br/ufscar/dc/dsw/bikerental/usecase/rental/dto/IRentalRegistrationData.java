package br.ufscar.dc.dsw.bikerental.usecase.rental.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalRegistrationData {

    String hour();

    String date();

    Long rentalCompanyId();

    Long customerId();
}
