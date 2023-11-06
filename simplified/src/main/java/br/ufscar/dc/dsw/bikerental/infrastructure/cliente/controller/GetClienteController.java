package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.GetClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetClienteController {

    private final GetClienteUseCase getClienteUseCase;

    public GetClienteController(GetClienteUseCase getClienteUseCase) {
        this.getClienteUseCase = getClienteUseCase;
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosCliente getCliente(@PathVariable Long id) throws CostumerNotFoundException {
        Costumer costumer = getClienteUseCase.execute(id);

        return new DadosPublicosCliente(costumer);
    }

}
