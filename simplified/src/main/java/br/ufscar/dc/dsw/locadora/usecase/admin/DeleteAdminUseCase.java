package br.ufscar.dc.dsw.locadora.usecase.admin;

import br.ufscar.dc.dsw.locadora.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;

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
