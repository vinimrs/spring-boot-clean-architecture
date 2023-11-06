package br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.CPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.Sex;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRegistrationData(
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

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @NotBlank
        @CPF(message = "{Size.customers.CPF}")
        String cpf,

        @NotBlank
        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.customer}")
        @NotBlank
        String sex,

        @BirthDateField(message = "{BirthDate.customer}")
        @NotNull
        String birthdate) implements ICustomerRegistrationData { }