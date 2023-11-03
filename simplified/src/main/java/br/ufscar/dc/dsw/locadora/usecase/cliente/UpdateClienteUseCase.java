package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosAtualizacaoCliente;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

// @Service
public class UpdateClienteUseCase {
    private final ClienteGateway clienteGateway;

    public UpdateClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(Long id, IDadosAtualizacaoCliente dados) throws ClienteNotFoundException {
        Cliente cliente = this.clienteGateway.findById(id)
                .orElseThrow(ClienteNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            cliente.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            cliente.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            cliente.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            cliente.setEmail(dados.email());

        if(dados.cpf() != null && !dados.cpf().isBlank())
            cliente.setCpf(dados.cpf());

        if(dados.phoneNumber() != null && !dados.phoneNumber().isBlank())
            cliente.setPhoneNumber(dados.phoneNumber());

        if(dados.sex() != null && !dados.sex().isBlank())
            cliente.setSex(Sexo.valueOf(dados.sex()));

        if(dados.birthdate() != null && !dados.birthdate().isBlank())
            cliente.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

//        if (dados.email() != null && !dados.email().equals(cliente.getEmail())) {
//            int quantidadeEmail = clienteGateway.findAllByEmail(dados.email()).size();
//            if (quantidadeEmail > 0) {
//                throw new ConstraintViolationException(
//
//                );
//            }
//        }
//
//        if (dados.username() != null && !dados.username().equals(cliente.getUsername())) {
//            int quantidadeUsername = clienteGateway.findAllByUsername(dados.username()).size();
//            if (quantidadeUsername > 0) {
//                throw new ConstraintViolationException(
//                    Collections.singleton(validator.validateProperty(cliente, "username").iterator().next())
//                );
//            }
//        }
//
//        if (dados.cpf() != null && !dados.cpf().equals(cliente.getCpf())) {
//            int quantidadeCpf = clienteGateway.findAllByCpf(dados.cpf()).size();
//            if (quantidadeCpf > 0) {
//                throw new ConstraintViolationException(
//                    Collections.singleton(validator.validateProperty(cliente, "cpf").iterator().next())
//                );
//            }
//        }

        return this.clienteGateway.update(cliente);
    }

}
