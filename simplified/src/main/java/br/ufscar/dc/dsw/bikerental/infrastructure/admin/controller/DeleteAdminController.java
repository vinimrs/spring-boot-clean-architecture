package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.AdminPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.admin.DeleteAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAdminController {

    private final DeleteAdminUseCase deleteAdminUserCase;

    public DeleteAdminController(DeleteAdminUseCase deleteAdminUserCase) {
        this.deleteAdminUserCase = deleteAdminUserCase;
    }

    @DeleteMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new AdminPublicData(deleteAdminUserCase.execute(id));
    }

}
