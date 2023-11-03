package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.validation.formats.cliente.BirthDateField;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.CPF;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.PhoneNumber;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.Sex;
import br.ufscar.dc.dsw.locadora.validation.formats.usuario.Name;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCPF;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueEmail;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueUsername;
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
    String birthdate) {
}
