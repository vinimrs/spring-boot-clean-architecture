package br.ufscar.dc.dsw.bikerental.dto.rental;

import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.dto.customer.CustomerPublicData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsRentalCompany(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,
    CustomerPublicData customer) {
  public RentalDetailsRentalCompany(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(), new CustomerPublicData(rental.getCustomer()));
  }

}
