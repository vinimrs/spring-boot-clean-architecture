package br.ufscar.dc.dsw.bikerental.usecase.admin;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IDadosAtualizacaoAdmin;

// @Service
public class UpdateAdminUseCase {
    private final AdminGateway adminGateway;

    public UpdateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id, IDadosAtualizacaoAdmin dados) throws AdminNotFoundException {
        Admin cliente = this.adminGateway.findById(id)
                .orElseThrow(AdminNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            cliente.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            cliente.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            cliente.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            cliente.setEmail(dados.email());

        return this.adminGateway.update(cliente);
    }

}
