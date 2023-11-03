package br.ufscar.dc.dsw.locadora.infrastructure.admin.controller;

import br.ufscar.dc.dsw.locadora.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.admin.dto.DadosPublicosAdmin;
import br.ufscar.dc.dsw.locadora.usecase.admin.DeleteAdminUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.DeleteClienteUseCase;
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
