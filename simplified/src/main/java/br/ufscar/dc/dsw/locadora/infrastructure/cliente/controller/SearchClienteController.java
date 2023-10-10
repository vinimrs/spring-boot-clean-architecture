package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.cliente.SearchClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SearchClienteController {

    private final SearchClienteUseCase searchClienteUseCase;

    public SearchClienteController(SearchClienteUseCase searchClienteUseCase) {
        this.searchClienteUseCase = searchClienteUseCase;
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public Response searchCliente() {
        var output = this.searchClienteUseCase.execute();

        return new Response(output.clientes());
    }

    public record Response(
            List<Cliente> clientes
    ) {}
}
