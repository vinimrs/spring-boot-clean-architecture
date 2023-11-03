package br.ufscar.dc.dsw.locadora.infrastructure.cliente.gateway;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;

import java.util.List;
import java.util.Optional;

public class ClienteDatabaseGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    public ClienteDatabaseGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return this.clienteRepository.save(new ClienteSchema(cliente)).toCliente();
    }

    @Override
    public Cliente update(Cliente cliente) {
        return this.clienteRepository.save(new ClienteSchema(cliente)).toCliente();
    }

    @Override
    public void delete(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository
                .findById(id)
                .map(ClienteSchema::toCliente);
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        return clienteRepository
                .findByCpf(cpf)
                .map(ClienteSchema::toCliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository
                .findAll()
                .stream()
                .map(ClienteSchema::toCliente)
                .toList();
    }
}
