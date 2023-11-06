package br.ufscar.dc.dsw.bikerental.entity.admin.gateway;

import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminGateway {
    Admin create(Admin admin);
    Admin update(Admin admin);
    void delete(Long id);

    Optional<Admin> findById(Long id);

    List<Admin> findAll();
}
