package br.ufscar.dc.dsw.bikerental.usecase.admin;

import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;

import java.util.List;

// @Service
public class SearchAdminUseCase {
    private final AdminGateway adminGateway;

    public SearchAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public List<Admin> execute() {
        return this.adminGateway.findAll();
    }


}
