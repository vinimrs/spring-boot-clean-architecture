package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.gateway;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalCompanyRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalCompanySchema;

import java.util.List;
import java.util.Optional;

public class RentalCompanyDatabaseGateway implements RentalCompanyGateway {

    private final RentalCompanyRepository rentalCompanyRepository;

    public RentalCompanyDatabaseGateway(RentalCompanyRepository rentalCompanyRepository) {
        this.rentalCompanyRepository = rentalCompanyRepository;
    }


    @Override
    public RentalCompany create(RentalCompany rentalCompany) {
        return this.rentalCompanyRepository.save(new RentalCompanySchema(rentalCompany)).toRentalCompany();
    }

    @Override
    public RentalCompany update(RentalCompany rentalCompany) {
        return this.rentalCompanyRepository.save(new RentalCompanySchema(rentalCompany)).toRentalCompany();
    }

    @Override
    public void delete(Long id) {
        this.rentalCompanyRepository.deleteById(id);
    }

    @Override
    public Optional<RentalCompany> findById(Long id) {
        return rentalCompanyRepository
                .findById(id)
                .map(RentalCompanySchema::toRentalCompany);
    }


    @Override
    public Optional<RentalCompany> findByCnpj(String cnpj) {
        return this.rentalCompanyRepository.findByCnpj(cnpj).map(RentalCompanySchema::toRentalCompany);
    }

    @Override
    public Optional<RentalCompany> findByName(String name) {
        return this.rentalCompanyRepository.findByName(name).map(RentalCompanySchema::toRentalCompany);
    }

    @Override
    public List<String> findAllCities() {
        return this.rentalCompanyRepository.findAllCities();
    }

    @Override
    public List<RentalCompany> findAllByCity(String city) {
        return this.rentalCompanyRepository.findAllByCity(city).stream().map(RentalCompanySchema::toRentalCompany).toList();
    }

    @Override
    public List<RentalCompany> findAll() {
        return rentalCompanyRepository
                .findAll()
                .stream()
                .map(RentalCompanySchema::toRentalCompany)
                .toList();
    }
}
