package br.ufscar.dc.dsw.bikerental.dto.customer;

import br.ufscar.dc.dsw.bikerental.validation.formats.customer.BirthDateField;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.CPF;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.PhoneNumber;
import br.ufscar.dc.dsw.bikerental.validation.formats.customer.Sex;
import br.ufscar.dc.dsw.bikerental.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record CUstomerUpdateData(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @CPF(message = "{Size.customer.CPF}")
    String cpf,

    @PhoneNumber(message = "{Size.customer.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.customer}")
    String sex,

    @BirthDateField(message = "{BirthDate.customer}")
    String birthdate) {
}
