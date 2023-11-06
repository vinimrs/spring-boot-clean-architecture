package br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IAdminRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminRegistrationData(
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
        String email) implements IAdminRegistrationData { }