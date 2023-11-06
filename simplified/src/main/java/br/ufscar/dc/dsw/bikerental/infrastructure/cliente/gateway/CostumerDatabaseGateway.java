package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.gateway;

import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.ClienteSchema;

import java.util.List;
import java.util.Optional;

public class CostumerDatabaseGateway implements CostumerGateway {

    private final ClienteRepository clienteRepository;

    public CostumerDatabaseGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Costumer create(Costumer costumer) {
        return this.clienteRepository.save(new ClienteSchema(costumer)).toCliente();
    }

    @Override
    public Costumer update(Costumer costumer) {
        return this.clienteRepository.save(new ClienteSchema(costumer)).toCliente();
    }

    @Override
    public void delete(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Costumer> findById(Long id) {
        return clienteRepository
                .findById(id)
                .map(ClienteSchema::toCliente);
    }

    @Override
    public Optional<Costumer> findByCpf(String cpf) {
        return clienteRepository
                .findByCpf(cpf)
                .map(ClienteSchema::toCliente);
    }

    @Override
    public List<Costumer> findAll() {
        return clienteRepository
                .findAll()
                .stream()
                .map(ClienteSchema::toCliente)
                .toList();
    }
}
