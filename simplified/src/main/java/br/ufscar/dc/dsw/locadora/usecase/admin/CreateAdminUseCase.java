package br.ufscar.dc.dsw.locadora.usecase.admin;

import br.ufscar.dc.dsw.locadora.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.admin.dto.IDadosCadastroAdmin;

// @Service
public class CreateAdminUseCase {
    private final AdminGateway adminGateway;

    public CreateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(IDadosCadastroAdmin dados) {

        Admin admin = new Admin(dados.username(), dados.password(), dados.name(),
            dados.email());

        return this.adminGateway.create(admin);
    }


}
