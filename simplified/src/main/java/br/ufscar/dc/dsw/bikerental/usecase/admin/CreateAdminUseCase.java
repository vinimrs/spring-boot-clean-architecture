package br.ufscar.dc.dsw.bikerental.usecase.admin;

import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IAdminRegistrationData;

// @Service
public class CreateAdminUseCase {
    private final AdminGateway adminGateway;

    public CreateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(IAdminRegistrationData dados) {

        Admin admin = new Admin(dados.username(), dados.password(), dados.name(),
            dados.email());

        return this.adminGateway.create(admin);
    }


}
