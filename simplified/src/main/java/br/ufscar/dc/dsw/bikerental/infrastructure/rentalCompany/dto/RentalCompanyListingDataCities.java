package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto;

import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyListingDataCities;

import java.util.List;

public record RentalCompanyListingDataCities(
    List<String> cities
) implements IRentalCompanyListingDataCities { }