package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;

import java.time.LocalDate;

// @Service
public class CreateClienteUseCase {
    private final ClienteGateway clienteGateway;

    public CreateClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public void execute(Input input) {
        Cliente cliente = new Cliente(input.username(), input.password(), input.name(),
                input.email(), input.cpf(), input.phoneNumber(), input.sex(),
                input.birthdate());
    }

    public record Input(String username,
                        String password,
                        String name,
                        String email,
                        String cpf,
                        String phoneNumber,
                        Sexo sex,
                        LocalDate birthdate) {}

}
