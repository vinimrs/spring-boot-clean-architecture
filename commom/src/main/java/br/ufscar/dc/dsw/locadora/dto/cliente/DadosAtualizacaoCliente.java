package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.validation.formats.cliente.BirthDateField;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.CPF;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.PhoneNumber;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.Sex;
import br.ufscar.dc.dsw.locadora.validation.formats.usuario.Name;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoCliente(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @CPF(message = "{Size.cliente.CPF}")
    String cpf,

    @PhoneNumber(message = "{Size.cliente.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.cliente}")
    String sex,

    @BirthDateField(message = "{BirthDate.cliente}")
    String birthdate) {
}
