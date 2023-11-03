package br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.CPF;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.Sex;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.validation.formats.CNPJ;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.validation.unique.UniqueCNPJ;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosAtualizacaoLocadora;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoLocadora(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
        @CNPJ(message = "{Size.locadora.CNPJ}")
        String cnpj,

        String city) implements IDadosAtualizacaoLocadora {
}
