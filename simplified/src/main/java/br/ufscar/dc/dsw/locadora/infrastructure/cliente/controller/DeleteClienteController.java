package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.usecase.cliente.DeleteClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.UpdateClienteUseCase;
import jakarta.validation.Valid;
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
    public DadosPublicosCliente createCliente(@PathVariable Long id) throws ClienteNotFoundException {
        return new DadosPublicosCliente(deleteClienteUseCase.execute(id));
    }

}
