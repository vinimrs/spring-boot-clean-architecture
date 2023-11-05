package br.ufscar.dc.dsw.locadora.dto.locadora;

import br.ufscar.dc.dsw.locadora.validation.formats.locadora.CNPJ;
import br.ufscar.dc.dsw.locadora.validation.formats.usuario.Name;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoLocadora(
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
