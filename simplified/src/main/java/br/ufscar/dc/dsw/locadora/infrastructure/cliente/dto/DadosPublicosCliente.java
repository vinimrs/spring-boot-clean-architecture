package br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.BirthDateField;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.PhoneNumber;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.Sex;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.unique.UniqueCPF;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.formats.Name;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueEmail;
import br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique.UniqueUsername;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosPublicosCliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosPublicosCliente(
        String id,

        String username,


        String password,

        String name,

        String email,

        String phoneNumber
) implements IDadosPublicosCliente {
        public DadosPublicosCliente(Cliente cliente) {
                this(
                        cliente.getId().toString(),
                        cliente.getUsername(),
                        cliente.getPassword(),
                        cliente.getName(),
                        cliente.getEmail(),
                        cliente.getPhoneNumber()
                );
        }
}