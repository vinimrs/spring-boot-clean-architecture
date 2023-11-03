package br.ufscar.dc.dsw.locadora.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosCadastroLocadora;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.locadora.CreateLocadoraUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateLocadoraController {

    private final CreateLocadoraUseCase createLocadoraUseCase;

    public CreateLocadoraController(CreateLocadoraUseCase createLocadoraUseCase) {
        this.createLocadoraUseCase = createLocadoraUseCase;
    }

    @PostMapping("/locadoras")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosLocadora createLocadora(@Valid @RequestBody DadosCadastroLocadora dados) {
        return new DadosPublicosLocadora(createLocadoraUseCase.execute(dados));
    }

}
