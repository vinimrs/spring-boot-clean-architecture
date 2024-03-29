package br.ufscar.dc.dsw.bikerental.dto.admin;

import br.ufscar.dc.dsw.bikerental.validation.formats.user.Name;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueUsername;
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
    String email) {
}
