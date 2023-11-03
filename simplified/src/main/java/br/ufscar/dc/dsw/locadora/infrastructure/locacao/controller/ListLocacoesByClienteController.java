package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.locacao.ListLocacoesByClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.SearchLocacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListLocacoesByClienteController {

    private final ListLocacoesByClienteUseCase listLocacoesUseCase;

    public ListLocacoesByClienteController(ListLocacoesByClienteUseCase listLocacoesUseCase) {
        this.listLocacoesUseCase = listLocacoesUseCase;
    }

    @GetMapping("/locacoes/clientes/{clienteId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao(@PathVariable Long clienteId) throws LocacaoNotFoundException, ClienteNotFoundException {
        List<Locacao> locacoes = this.listLocacoesUseCase.execute(clienteId);

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
