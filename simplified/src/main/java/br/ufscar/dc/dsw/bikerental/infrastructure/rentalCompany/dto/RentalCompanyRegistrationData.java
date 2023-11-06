package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.formats.CNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RentalCompanyRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email
        String email,

        @UniqueCNPJ(message = "{Unique.rentalCompany.CNPJ}")
        @NotBlank
        @CNPJ(message = "{Size.rentalCompany.CNPJ}")
        String cnpj,

        @NotBlank
        String city) implements IRentalCompanyRegistrationData { }