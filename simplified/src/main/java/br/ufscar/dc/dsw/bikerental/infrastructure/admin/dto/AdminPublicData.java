package br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto;

import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.dto.IAdminPublicData;

public record AdminPublicData(
        String id,

        String username,

        String name,

        String email
) implements IAdminPublicData {
        public AdminPublicData(Admin admin) {
                this(
                    admin.getId().toString(),
                    admin.getUsername(),
                    admin.getName(),
                    admin.getEmail()
                );
        }
}