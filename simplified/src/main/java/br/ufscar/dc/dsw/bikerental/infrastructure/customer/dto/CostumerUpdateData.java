package br.ufscar.dc.dsw.bikerental.infrastructure.customer.dto;

import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.CPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.formats.Name;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.bikerental.usecase.customer.dto.ICustomerUpdateData;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.validation.formats.Sex;
import jakarta.validation.constraints.Email;

public record CostumerUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @CPF(message = "{Size.customer.CPF}")
        String cpf,

        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.customer}")
        String sex,

        @BirthDateField(message = "{BirthDate.customer}")
        String birthdate) implements ICustomerUpdateData {
}
