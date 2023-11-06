package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.AdminPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.admin.SearchAdminUseCase;
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
    public List<AdminPublicData> searchAdmin() {
        List<Admin> admins = this.searchAdminUseCase.execute();

        return admins.stream().map(AdminPublicData::new).toList();
    }

}
