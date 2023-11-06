package br.ufscar.dc.dsw.bikerental.infrastructure.admin.controller;

import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.DadosCadastroAdmin;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.dto.DadosPublicosAdmin;
import br.ufscar.dc.dsw.bikerental.usecase.admin.CreateAdminUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAdminController {

    private final CreateAdminUseCase createAdminUseCase;

    public CreateAdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosAdmin createCliente(@Valid @RequestBody DadosCadastroAdmin dados) {
        return new DadosPublicosAdmin(createAdminUseCase.execute(dados));
    }

}
