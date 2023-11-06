package br.ufscar.dc.dsw.bikerental.infrastructure.rental.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.classlevel.ValidRentalRegistrationData;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.formats.RentalDate;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.validation.formats.RentalHour;

import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IRentalRegistrationData;
import jakarta.validation.constraints.NotNull;

@ValidRentalRegistrationData(message = "{ValidRental.rental}")
public record RentalRegistrationData(
    @RentalHour(message = "{Hour.rental}")
    @NotNull
    String hour,

    @RentalDate(message = "{Date.rental}")
    @NotNull
    String date,

    @NotNull
    Long rentalCompanyId,

    @NotNull
    Long customerId
    ) implements IRentalRegistrationData { }