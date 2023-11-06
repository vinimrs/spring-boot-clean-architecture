package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.SearchClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchClienteController {

    private final SearchClienteUseCase searchClienteUseCase;

    public SearchClienteController(SearchClienteUseCase searchClienteUseCase) {
        this.searchClienteUseCase = searchClienteUseCase;
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosCliente> searchCliente() {
        List<Costumer> costumers = this.searchClienteUseCase.execute();

        return costumers.stream().map(DadosPublicosCliente::new).toList();
    }

}
