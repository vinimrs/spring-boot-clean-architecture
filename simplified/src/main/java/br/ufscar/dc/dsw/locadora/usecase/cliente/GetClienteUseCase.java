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

    public Cliente execute(Long id) throws ClienteNotFoundException {
        return this.clienteGateway
                .findById(id)
                .orElseThrow(ClienteNotFoundException::new);
    }

}
