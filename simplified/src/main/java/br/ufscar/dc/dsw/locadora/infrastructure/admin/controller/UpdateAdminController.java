package br.ufscar.dc.dsw.locadora.infrastructure.admin.controller;

import br.ufscar.dc.dsw.locadora.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.admin.dto.DadosAtualizacaoAdmin;
import br.ufscar.dc.dsw.locadora.infrastructure.admin.dto.DadosPublicosAdmin;
import br.ufscar.dc.dsw.locadora.usecase.admin.UpdateAdminUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.UpdateClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateAdminController {

    private final UpdateAdminUseCase updateAdminUseCase;

    public UpdateAdminController(UpdateAdminUseCase updateAdminUseCase) {
        this.updateAdminUseCase = updateAdminUseCase;
    }

    @PutMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosAdmin updateAdmin(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoAdmin dados) throws AdminNotFoundException {
        return new DadosPublicosAdmin(updateAdminUseCase.execute(id, dados));
    }

}
