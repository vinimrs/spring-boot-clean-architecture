package br.ufscar.dc.dsw.locadora.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.cliente.SearchClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locadora.SearchLocadoraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchLocadoraController {

    private final SearchLocadoraUseCase searchLocadoraUseCase;

    public SearchLocadoraController(SearchLocadoraUseCase searchLocadoraUseCase) {
        this.searchLocadoraUseCase = searchLocadoraUseCase;
    }

    @GetMapping("/locadoras")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocadora> searchCliente() {
        List<Locadora> locadoras = this.searchLocadoraUseCase.execute();

        return locadoras.stream().map(DadosPublicosLocadora::new).toList();
    }

}
