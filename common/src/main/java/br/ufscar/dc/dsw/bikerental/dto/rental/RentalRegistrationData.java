package br.ufscar.dc.dsw.bikerental.dto.rental;

import br.ufscar.dc.dsw.bikerental.validation.classlevel.ValidRentalRegistration;
import br.ufscar.dc.dsw.bikerental.validation.formats.rental.RentalDate;
import br.ufscar.dc.dsw.bikerental.validation.formats.rental.RentalHour;
import jakarta.validation.constraints.NotNull;

@ValidRentalRegistration(message = "{ValidRental.rental}")
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
    Long customerId) {
}
