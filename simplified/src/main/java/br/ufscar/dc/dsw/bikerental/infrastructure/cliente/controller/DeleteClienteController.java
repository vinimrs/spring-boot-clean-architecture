package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.DeleteClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteClienteController {

    private final DeleteClienteUseCase deleteClienteUseCase;

    public DeleteClienteController(DeleteClienteUseCase deleteClienteUseCase) {
        this.deleteClienteUseCase = deleteClienteUseCase;
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosCliente createCliente(@PathVariable Long id) throws CostumerNotFoundException {
        return new DadosPublicosCliente(deleteClienteUseCase.execute(id));
    }

}
