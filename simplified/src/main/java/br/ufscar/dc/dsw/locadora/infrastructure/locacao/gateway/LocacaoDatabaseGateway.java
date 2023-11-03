package br.ufscar.dc.dsw.locadora.infrastructure.locacao.gateway;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.gateway.LocacaoGateway;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocacaoSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;

import java.util.List;
import java.util.Optional;

public class LocacaoDatabaseGateway implements LocacaoGateway {

    private final LocacaoRepository locacaoRepository;

    public LocacaoDatabaseGateway(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public Locacao create(Locacao locacao) {
        return this.locacaoRepository.save(new LocacaoSchema(locacao)).toLocacao();
    }

    @Override
    public void delete(Long id) {
        this.locacaoRepository.deleteById(id);
    }

    @Override
    public Optional<Locacao> findById(Long id) {
        return locacaoRepository
                .findById(id)
                .map(LocacaoSchema::toLocacao);
    }


    @Override
    public List<Locacao> findAllByRentalCompany(Locadora rentalCompany) {
        return this.locacaoRepository.findAllByRentalCompany(new LocadoraSchema(rentalCompany))
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }

    @Override
    public List<Locacao> findAllByClient(Cliente client) {
        return this.locacaoRepository.findAllByClient(new ClienteSchema(client))
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }


    @Override
    public List<Locacao> findAll() {
        return locacaoRepository
                .findAll()
                .stream()
                .map(LocacaoSchema::toLocacao)
                .toList();
    }
}
