package br.ufscar.dc.dsw.locadora.infrastructure.admin.dto;

import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.usecase.admin.dto.IDadosPublicosAdmin;
import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosPublicosCliente;

public record DadosPublicosAdmin(
        String id,

        String username,

        String name,

        String email
) implements IDadosPublicosAdmin {
        public DadosPublicosAdmin(Admin admin) {
                this(
                    admin.getId().toString(),
                    admin.getUsername(),
                    admin.getName(),
                    admin.getEmail()
                );
        }
}