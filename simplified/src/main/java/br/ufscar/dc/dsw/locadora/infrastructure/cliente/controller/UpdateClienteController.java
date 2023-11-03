package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.UpdateClienteUseCase;
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
    public DadosPublicosCliente createCliente(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoCliente dados) throws ClienteNotFoundException {
        return new DadosPublicosCliente(updateClienteUseCase.execute(id, dados));
    }

}
