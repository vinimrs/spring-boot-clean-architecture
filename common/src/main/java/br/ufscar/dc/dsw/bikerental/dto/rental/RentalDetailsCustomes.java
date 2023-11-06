package br.ufscar.dc.dsw.bikerental.dto.rental;

import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyPublicListingData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsCustomes(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date, RentalCompanyPublicListingData rentalCompany) {
  public RentalDetailsCustomes(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(),
        new RentalCompanyPublicListingData(rental.getRentalCompany()));
  }

}
