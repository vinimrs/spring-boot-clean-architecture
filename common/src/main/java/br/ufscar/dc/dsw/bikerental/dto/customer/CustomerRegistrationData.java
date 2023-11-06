package br.ufscar.dc.dsw.bikerental.dto.customer;

import br.ufscar.dc.dsw.bikerental.validation.formats.customer.BirthDateField;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.CPF;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.PhoneNumber;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.Sex;
import br.ufscar.dc.dsw.bikerental.validation.formats.user.Name;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueCPF;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueUsername;
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
    @CPF(message = "{Size.customer.CPF}")
    String cpf,

    @NotBlank
    @PhoneNumber(message = "{Size.customer.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.customer}")
    @NotBlank
    String sex,

    @BirthDateField(message = "{BirthDate.customer}")
    @NotNull
    String birthdate) {
}
