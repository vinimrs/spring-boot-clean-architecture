package br.ufscar.dc.dsw.bikerental.dto.admin;

import br.ufscar.dc.dsw.bikerental.domain.Admin;

public record AdminDetails(Long id, String username, String name, String email) {
    public AdminDetails(Admin admin) {
        this(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail());
    }

}
