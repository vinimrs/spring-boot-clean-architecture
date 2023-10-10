package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;

import java.time.LocalDate;
import java.util.List;

// @Service
public class SearchClienteUseCase {
    private final ClienteGateway clienteGateway;

    public SearchClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Output execute() {
        return new Output(this.clienteGateway.findAll());
    }

    public record Output(
            List<Cliente> clientes
    ) {}

}
