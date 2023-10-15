package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.GetClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class GetClienteController {

    private final GetClienteUseCase getClienteUseCase;

    public GetClienteController(GetClienteUseCase getClienteUseCase) {
        this.getClienteUseCase = getClienteUseCase;
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosCliente getCliente(@PathVariable Long id) throws ClienteNotFoundException {
        Cliente cliente = getClienteUseCase.execute(id);

        return new DadosPublicosCliente(cliente);
    }

}
