package br.ufscar.dc.dsw.locadora.infrastructure.admin.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.admin.dto.IDadosAtualizacaoAdmin;
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
