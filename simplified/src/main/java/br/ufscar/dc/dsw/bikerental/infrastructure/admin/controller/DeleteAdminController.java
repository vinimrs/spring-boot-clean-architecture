package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.DadosPublicosAdmin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.DeleteAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAdminController {

    private final DeleteAdminUseCase deleteClienteUseCase;

    public DeleteAdminController(DeleteAdminUseCase deleteClienteUseCase) {
        this.deleteClienteUseCase = deleteClienteUseCase;
    }

    @DeleteMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosAdmin deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new DadosPublicosAdmin(deleteClienteUseCase.execute(id));
    }

}
