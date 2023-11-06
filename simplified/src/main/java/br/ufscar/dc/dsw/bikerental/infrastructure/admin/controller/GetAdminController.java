package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.admin.model.Admin;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.AdminPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.admin.GetAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAdminController {

    private final GetAdminUseCase getAdminUseCase;

    public GetAdminController(GetAdminUseCase getAdminUseCase) {
        this.getAdminUseCase = getAdminUseCase;
    }

    @GetMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminPublicData getAdmin(@PathVariable Long id) throws AdminNotFoundException {
        Admin admin = getAdminUseCase.execute(id);

        return new AdminPublicData(admin);
    }

}
