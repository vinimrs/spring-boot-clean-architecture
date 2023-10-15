package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateClienteController {

    private final CreateClienteUseCase createClienteUseCase;

    public CreateClienteController(CreateClienteUseCase createClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase;
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosCliente createCliente(@Valid @RequestBody DadosCadastroCliente dados) {
        return new DadosPublicosCliente(createClienteUseCase.execute(dados));
    }

}
