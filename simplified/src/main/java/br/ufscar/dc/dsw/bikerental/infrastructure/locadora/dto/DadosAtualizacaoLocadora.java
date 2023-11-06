package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.validation.formats.CNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosAtualizacaoLocadora;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoLocadora(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
        @CNPJ(message = "{Size.locadora.CNPJ}")
        String cnpj,

        String city) implements IDadosAtualizacaoLocadora {
}
