package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.locacao.ListLocacoesByClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.ListLocacoesByLocadoraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListLocacoesByLocadoraController {

    private final ListLocacoesByLocadoraUseCase listLocacoesUseCase;

    public ListLocacoesByLocadoraController(ListLocacoesByLocadoraUseCase listLocacoesUseCase) {
        this.listLocacoesUseCase = listLocacoesUseCase;
    }

    @GetMapping("/locacoes/locadoras/{locadoraId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao(@PathVariable Long locadoraId) throws LocacaoNotFoundException, LocadoraNotFoundException {
        List<Locacao> locacoes = this.listLocacoesUseCase.execute(locadoraId);

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
