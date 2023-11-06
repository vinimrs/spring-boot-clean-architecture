package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.formats.CPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.formats.Sex;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.dto.IDadosCadastroCliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
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

        @UniqueCPF(message = "{Unique.cliente.CPF}")
        @NotBlank
        @CPF(message = "{Size.cliente.CPF}")
        String cpf,

        @NotBlank
        @PhoneNumber(message = "{Size.cliente.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.cliente}")
        @NotBlank
        String sex,

        @BirthDateField(message = "{BirthDate.cliente}")
        @NotNull
        String birthdate) implements IDadosCadastroCliente { }