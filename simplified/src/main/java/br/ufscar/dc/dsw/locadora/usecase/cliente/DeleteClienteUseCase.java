package br.ufscar.dc.dsw.locadora.usecase.cliente;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosAtualizacaoCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class DeleteClienteUseCase {
    private final ClienteGateway clienteGateway;

    public DeleteClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(Long id) throws ClienteNotFoundException {
        Cliente cliente = clienteGateway.findById(id)
            .orElseThrow(ClienteNotFoundException::new);

        clienteGateway.delete(id);

        return cliente;
    }

}
