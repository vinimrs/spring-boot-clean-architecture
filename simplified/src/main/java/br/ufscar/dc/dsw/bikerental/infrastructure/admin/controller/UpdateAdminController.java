package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.entity.admin.exception.AdminNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.AdminUpdateData;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.AdminPublicData;
import br.ufscar.dc.dsw.bikerental.usecase.admin.UpdateAdminUseCase;
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
    public AdminPublicData updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateData dados) throws AdminNotFoundException {
        return new AdminPublicData(updateAdminUseCase.execute(id, dados));
    }

}
