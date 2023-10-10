package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;

import java.time.LocalDate;

// @Service
public class GetClienteUseCase {
    private final ClienteGateway clienteGateway;

    public GetClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Output execute(Input input) throws ClienteNotFoundException {
        Cliente cliente = this.clienteGateway
                .findById(input.id())
                .orElseThrow(ClienteNotFoundException::new);

        return new Output(cliente);
    }

    public record Input(Long id) {}

    public record Output(Cliente cliente) {}
}
