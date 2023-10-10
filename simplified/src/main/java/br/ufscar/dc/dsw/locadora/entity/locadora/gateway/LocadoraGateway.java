package br.ufscar.dc.dsw.locadora.entity.locadora.gateway;


import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

import java.util.List;
import java.util.Optional;

public interface LocadoraGateway {
    void create(Locadora locadora);
    void update(Locadora locadora);
    void delete(Long id);

    Optional<Locadora> findById(Long id);
    List<Locadora> searchByName(String nameFragment);
    List<Locadora> findAllByCnpj(String cnpj);

    Locadora findByCnpj(String cnpj);

    List<String> findAllCities();

    List<Locadora> findAllByCity(String city);
}
