package br.ufscar.dc.dsw.locadora.entity.locacao.gateway;


import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

import java.util.List;
import java.util.Optional;

public interface LocacaoGateway {
    Locacao create(Locacao locacao);
    void delete(Long id);

    Optional<Locacao> findById(Long id);

    List<Locacao> findAllByRentalCompany(Locadora rentalCompany);

    List<Locacao> findAllByClient(Cliente client);

    List<Locacao> findAll();
}
