package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.UpdateClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateClienteController {

    private final UpdateClienteUseCase updateClienteUseCase;

    public UpdateClienteController(UpdateClienteUseCase updateClienteUseCase) {
        this.updateClienteUseCase = updateClienteUseCase;
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosCliente createCliente(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoCliente dados) throws CostumerNotFoundException {
        return new DadosPublicosCliente(updateClienteUseCase.execute(id, dados));
    }

}
