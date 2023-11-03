package br.ufscar.dc.dsw.locadora.infrastructure.admin.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.admin.dto.IDadosCadastroAdmin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAdmin(
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
        String email) implements IDadosCadastroAdmin { }