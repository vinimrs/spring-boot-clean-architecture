package br.ufscar.dc.dsw.locadora.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.cliente.GetClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locadora.GetLocadoraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocadoraController {

    private final GetLocadoraUseCase getLocadoraUseCase;

    public GetLocadoraController(GetLocadoraUseCase getLocadoraUseCase) {
        this.getLocadoraUseCase = getLocadoraUseCase;
    }

    @GetMapping("/locadoras/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosLocadora getLocadora(@PathVariable Long id) throws LocadoraNotFoundException {
        Locadora locadora = getLocadoraUseCase.execute(id);

        return new DadosPublicosLocadora(locadora);
    }

}
