package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosCadastroCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateClienteUseCase {
    private final ClienteGateway clienteGateway;

    public CreateClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(IDadosCadastroCliente dados) {

        Cliente cliente = new Cliente(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cpf(), dados.phoneNumber(), Sexo.valueOf(dados.sex()),
            LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return this.clienteGateway.create(cliente);
    }


}
