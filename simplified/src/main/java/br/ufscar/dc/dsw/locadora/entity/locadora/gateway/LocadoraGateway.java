package br.ufscar.dc.dsw.locadora.entity.locadora.gateway;


import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

import java.util.List;
import java.util.Optional;

public interface LocadoraGateway {
    Locadora create(Locadora locadora);
    Locadora update(Locadora locadora);
    void delete(Long id);

    Optional<Locadora> findById(Long id);

    Optional<Locadora> findByCnpj(String cnpj);
    Optional<Locadora> findByName(String name);

    List<String> findAllCities();

    List<Locadora> findAllByCity(String city);

    List<Locadora> findAll();
}
