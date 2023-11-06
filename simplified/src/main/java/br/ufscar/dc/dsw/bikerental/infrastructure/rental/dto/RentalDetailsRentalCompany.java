package br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto.CustomerPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IRentalDetailsRentalCompany;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsRentalCompany(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    CustomerPublicData customer
) implements IRentalDetailsRentalCompany {
        public RentalDetailsRentalCompany(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new CustomerPublicData(rental.getCustomer())
                );
        }
}