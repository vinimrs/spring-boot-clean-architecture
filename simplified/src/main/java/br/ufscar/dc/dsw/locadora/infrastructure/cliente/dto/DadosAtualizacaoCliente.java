package br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.CPF;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.Sex;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoCliente(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCPF(message = "{Unique.cliente.CPF}")
        @CPF(message = "{Size.cliente.CPF}")
        String cpf,

        @PhoneNumber(message = "{Size.cliente.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.cliente}")
        String sex,

        @BirthDateField(message = "{BirthDate.cliente}")
        String birthdate) implements IDadosAtualizacaoCliente {
}
