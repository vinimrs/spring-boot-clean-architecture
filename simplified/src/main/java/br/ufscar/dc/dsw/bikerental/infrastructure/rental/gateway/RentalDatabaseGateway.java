package br.ufscar.dc.dsw.bikerental.infrastructure.rental.gateway;

import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalCompanySchema;

import java.util.List;
import java.util.Optional;

public class RentalDatabaseGateway implements RentalGateway {

    private final RentalRepository rentalRepository;

    public RentalDatabaseGateway(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental create(Rental rental) {
        return this.rentalRepository.save(new RentalSchema(rental)).toRental();
    }

    @Override
    public void delete(Long id) {
        this.rentalRepository.deleteById(id);
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return rentalRepository
                .findById(id)
                .map(RentalSchema::toRental);
    }


    @Override
    public List<Rental> findAllByRentalCompany(RentalCompany rentalCompany) {
        return this.rentalRepository.findAllByRentalCompany(new RentalCompanySchema(rentalCompany))
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }

    @Override
    public List<Rental> findAllByCustomer(Customer customer) {
        return this.rentalRepository.findAllByCustomer(new CustomerSchema(customer))
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }


    @Override
    public List<Rental> findAll() {
        return rentalRepository
                .findAll()
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }
}
