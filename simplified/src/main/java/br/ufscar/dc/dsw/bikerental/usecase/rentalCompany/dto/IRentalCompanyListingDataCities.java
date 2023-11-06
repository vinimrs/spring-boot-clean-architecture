package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto;

import java.util.List;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalCompanyListingDataCities {

    List<String> cities();
}
