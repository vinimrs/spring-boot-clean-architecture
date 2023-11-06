package br.ufscar.dc.dsw.bikerental.entity.costumer.gateway;


import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;

import java.util.List;
import java.util.Optional;

public interface CostumerGateway {
    Costumer create(Costumer costumer);
    Costumer update(Costumer costumer);
    void delete(Long id);

    Optional<Costumer> findById(Long id);
    Optional<Costumer> findByCpf(String cpf);

    List<Costumer> findAll();
}
