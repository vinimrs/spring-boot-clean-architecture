package br.ufscar.dc.dsw.bikerental.dto.rentalCompany;

import br.ufscar.dc.dsw.bikerental.validation.formats.rentalCompany.CNPJ;
import br.ufscar.dc.dsw.bikerental.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record RentalCompanyUpdateData(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @CNPJ(message = "{Size.locadora.CNPJ}")
    String cnpj,

    String city) {
}
