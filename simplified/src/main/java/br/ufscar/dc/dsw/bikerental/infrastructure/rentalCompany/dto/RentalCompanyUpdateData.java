package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.formats.CNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyUpdateData;
import jakarta.validation.constraints.Email;

public record RentalCompanyUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCNPJ(message = "{Unique.rentalCompany.CNPJ}")
        @CNPJ(message = "{Size.rentalCompany.CNPJ}")
        String cnpj,

        String city) implements IRentalCompanyUpdateData {
}
