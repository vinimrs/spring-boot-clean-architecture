package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.cliente.SearchClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.SearchLocacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchLocacaoController {

    private final SearchLocacaoUseCase searchLocacaoUseCase;

    public SearchLocacaoController(SearchLocacaoUseCase searchLocacaoUseCase) {
        this.searchLocacaoUseCase = searchLocacaoUseCase;
    }

    @GetMapping("/locacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao() {
        List<Locacao> locacoes = this.searchLocacaoUseCase.execute();

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
