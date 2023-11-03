package br.ufscar.dc.dsw.locadora.infrastructure.locadora.gateway;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocadoraRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;

import java.util.List;
import java.util.Optional;

public class LocadoraDatabaseGateway implements LocadoraGateway {

    private final LocadoraRepository locadoraRepository;

    public LocadoraDatabaseGateway(LocadoraRepository locadoraRepository) {
        this.locadoraRepository = locadoraRepository;
    }


    @Override
    public Locadora create(Locadora locadora) {
        return this.locadoraRepository.save(new LocadoraSchema(locadora)).toLocadora();
    }

    @Override
    public Locadora update(Locadora locadora) {
        return this.locadoraRepository.save(new LocadoraSchema(locadora)).toLocadora();
    }

    @Override
    public void delete(Long id) {
        this.locadoraRepository.deleteById(id);
    }

    @Override
    public Optional<Locadora> findById(Long id) {
        return locadoraRepository
                .findById(id)
                .map(LocadoraSchema::toLocadora);
    }


    @Override
    public Optional<Locadora> findByCnpj(String cnpj) {
        return this.locadoraRepository.findByCnpj(cnpj).map(LocadoraSchema::toLocadora);
    }

    @Override
    public Optional<Locadora> findByName(String name) {
        return this.locadoraRepository.findByName(name).map(LocadoraSchema::toLocadora);
    }

    @Override
    public List<String> findAllCities() {
        return this.locadoraRepository.findAllCities();
    }

    @Override
    public List<Locadora> findAllByCity(String city) {
        return this.locadoraRepository.findAllByCity(city).stream().map(LocadoraSchema::toLocadora).toList();
    }

    @Override
    public List<Locadora> findAll() {
        return locadoraRepository
                .findAll()
                .stream()
                .map(LocadoraSchema::toLocadora)
                .toList();
    }
}
