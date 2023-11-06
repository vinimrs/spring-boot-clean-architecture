package br.ufscar.dc.dsw.bikerental.usecase.admin;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;

// @Service
public class DeleteAdminUseCase {
    private final AdminGateway adminGateway;

    public DeleteAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        Admin admin = adminGateway.findById(id)
            .orElseThrow(AdminNotFoundException::new);

        adminGateway.delete(id);

        return admin;
    }

}
