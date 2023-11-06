package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.validation.formats.CNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosCadastroLocadora;
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