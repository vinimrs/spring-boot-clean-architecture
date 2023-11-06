package br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto.RentalCompanyPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IRentalDetailsCustomer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsCustomer(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    RentalCompanyPublicData rentalCompany
) implements IRentalDetailsCustomer {
        public RentalDetailsCustomer(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new RentalCompanyPublicData(rental.getRentalCompany())
                );
        }
}