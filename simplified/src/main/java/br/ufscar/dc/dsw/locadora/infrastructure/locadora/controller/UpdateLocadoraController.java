package br.ufscar.dc.dsw.locadora.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.cliente.UpdateClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locadora.UpdateLocadoraUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateLocadoraController {

    private final UpdateLocadoraUseCase updateLocadoraUseCase;

    public UpdateLocadoraController(UpdateLocadoraUseCase updateLocadoraUseCase) {
        this.updateLocadoraUseCase = updateLocadoraUseCase;
    }

    @PutMapping("/locadoras/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocadora updateLocadora(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoLocadora dados) throws LocadoraNotFoundException {
        return new DadosPublicosLocadora(updateLocadoraUseCase.execute(id, dados));
    }

}
