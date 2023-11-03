package br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.locadora.validation.formats.CNPJ;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosCadastroLocadora;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLocadora(
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

        @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
        @NotBlank
        @CNPJ(message = "{Size.locadora.CNPJ}")
        String cnpj,

        @NotBlank
        String city) implements IDadosCadastroLocadora { }