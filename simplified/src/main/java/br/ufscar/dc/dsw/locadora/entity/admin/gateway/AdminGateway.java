package br.ufscar.dc.dsw.locadora.entity.admin.gateway;


import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;

import java.util.Optional;

public interface AdminGateway {
    void create(Admin admin);
    void update(Admin admin);
    void delete(Long id);

    Optional<Admin> findById(Long id);
}
