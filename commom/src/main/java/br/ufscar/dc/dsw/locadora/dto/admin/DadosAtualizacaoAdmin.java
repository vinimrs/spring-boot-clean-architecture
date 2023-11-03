package br.ufscar.dc.dsw.locadora.dto.admin;

import br.ufscar.dc.dsw.locadora.validation.formats.usuario.Name;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoAdmin(
    String username,
    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email
) {
}
