package br.ufscar.dc.dsw.locadora.dto.admin;

import br.ufscar.dc.dsw.locadora.domain.Admin;

public record DadosDetalhamentoAdmin(Long id, String username, String name, String email) {
    public DadosDetalhamentoAdmin(Admin admin) {
        this(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail());
    }

}
