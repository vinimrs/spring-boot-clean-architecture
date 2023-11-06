package br.ufscar.dc.dsw.bikerental.dto.rental;

import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.dto.customer.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyPublicListingData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetails(
    Long id,
    @JsonFormat(pattern = "HH:00")
    LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date, RentalCompanyPublicListingData rentalCompany,
    CustomerPublicData customer) {
  public RentalDetails(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(),
        new RentalCompanyPublicListingData(rental.getRentalCompany()), new CustomerPublicData(rental.getCustomer()));
  }

}
