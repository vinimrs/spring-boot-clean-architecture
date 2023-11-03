package br.ufscar.dc.dsw.locadora.entity.cliente.gateway;


import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(Long id);

    Optional<Cliente> findById(Long id);
    Optional<Cliente> findByCpf(String cpf);

    List<Cliente> findAll();
}
