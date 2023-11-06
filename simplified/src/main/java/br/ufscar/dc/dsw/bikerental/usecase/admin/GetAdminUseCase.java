package br.ufscar.dc.dsw.bikerental.usecase.admin;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;

// @Service
public class GetAdminUseCase {
    private final AdminGateway adminGateway;

    public GetAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        return this.adminGateway
                .findById(id)
                .orElseThrow(AdminNotFoundException::new);
    }

}
