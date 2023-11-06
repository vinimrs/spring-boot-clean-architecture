package br.ufscar.dc.dsw.bikerental.dto.admin;

import br.ufscar.dc.dsw.bikerental.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record AdminUpdateData(
    String username,
    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email
) {
}
