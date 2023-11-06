package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalCompanyPublicData {

    String id();

    String name();

    String email();

    String city();

}
