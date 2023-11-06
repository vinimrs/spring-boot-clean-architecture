package br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IDadosAtualizacaoAdmin;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoAdmin(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email) implements IDadosAtualizacaoAdmin {
}
