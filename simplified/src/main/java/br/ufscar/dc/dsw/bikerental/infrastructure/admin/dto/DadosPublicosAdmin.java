package br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto;

import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IDadosPublicosAdmin;

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