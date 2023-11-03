package br.ufscar.dc.dsw.locadora.infrastructure.admin.controller;

import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.infrastructure.admin.dto.DadosPublicosAdmin;
import br.ufscar.dc.dsw.locadora.usecase.admin.SearchAdminUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.SearchClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchAdminController {

    private final SearchAdminUseCase searchAdminUseCase;

    public SearchAdminController(SearchAdminUseCase searchAdminUseCase) {
        this.searchAdminUseCase = searchAdminUseCase;
    }

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosAdmin> searchCliente() {
        List<Admin> admins = this.searchAdminUseCase.execute();

        return admins.stream().map(DadosPublicosAdmin::new).toList();
    }

}
