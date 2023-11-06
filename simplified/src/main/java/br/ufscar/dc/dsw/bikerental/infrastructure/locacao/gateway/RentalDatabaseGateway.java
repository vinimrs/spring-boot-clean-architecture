package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.gateway;

import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.LocacaoSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.LocadoraSchema;

import java.util.List;
import java.util.Optional;

public class RentalDatabaseGateway implements RentalGateway {

    private final LocacaoRepository locacaoRepository;

    public RentalDatabaseGateway(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public Rental create(Rental rental) {
        return this.locacaoRepository.save(new LocacaoSchema(rental)).toLocacao();
    }

    @Override
    public void delete(Long id) {
        this.locacaoRepository.deleteById(id);
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return locacaoRepository
                .findById(id)
                .map(LocacaoSchema::toLocacao);
    }


    @Override
    public List<Rental> findAllByRentalCompany(RentalCompany rentalCompany) {
        return this.locacaoRepository.findAllByRentalCompany(new LocadoraSchema(rentalCompany))
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }

    @Override
    public List<Rental> findAllByClient(Costumer client) {
        return this.locacaoRepository.findAllByClient(new ClienteSchema(client))
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }


    @Override
    public List<Rental> findAll() {
        return locacaoRepository
                .findAll()
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }
}
