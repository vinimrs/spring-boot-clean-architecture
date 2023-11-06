package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.gateway;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.LocadoraRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.LocadoraSchema;

import java.util.List;
import java.util.Optional;

public class RentalCompanyDatabaseGateway implements RentalCompanyGateway {

    private final LocadoraRepository locadoraRepository;

    public RentalCompanyDatabaseGateway(LocadoraRepository locadoraRepository) {
        this.locadoraRepository = locadoraRepository;
    }


    @Override
    public RentalCompany create(RentalCompany rentalCompany) {
        return this.locadoraRepository.save(new LocadoraSchema(rentalCompany)).toLocadora();
    }

    @Override
    public RentalCompany update(RentalCompany rentalCompany) {
        return this.locadoraRepository.save(new LocadoraSchema(rentalCompany)).toLocadora();
    }

    @Override
    public void delete(Long id) {
        this.locadoraRepository.deleteById(id);
    }

    @Override
    public Optional<RentalCompany> findById(Long id) {
        return locadoraRepository
                .findById(id)
                .map(LocadoraSchema::toLocadora);
    }


    @Override
    public Optional<RentalCompany> findByCnpj(String cnpj) {
        return this.locadoraRepository.findByCnpj(cnpj).map(LocadoraSchema::toLocadora);
    }

    @Override
    public Optional<RentalCompany> findByName(String name) {
        return this.locadoraRepository.findByName(name).map(LocadoraSchema::toLocadora);
    }

    @Override
    public List<String> findAllCities() {
        return this.locadoraRepository.findAllCities();
    }

    @Override
    public List<RentalCompany> findAllByCity(String city) {
        return this.locadoraRepository.findAllByCity(city).stream().map(LocadoraSchema::toLocadora).toList();
    }

    @Override
    public List<RentalCompany> findAll() {
        return locadoraRepository
                .findAll()
                .stream()
                .map(LocadoraSchema::toLocadora)
                .toList();
    }
}
