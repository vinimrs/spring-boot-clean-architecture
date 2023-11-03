package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.cliente.GetClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.GetLocacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocacaoController {

    private final GetLocacaoUseCase getLocacaoUseCase;

    public GetLocacaoController(GetLocacaoUseCase getLocacaoUseCase) {
        this.getLocacaoUseCase = getLocacaoUseCase;
    }

    @GetMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocacao getLocacao(@PathVariable Long id) throws LocacaoNotFoundException {
        Locacao locacao = getLocacaoUseCase.execute(id);

        return new DadosPublicosLocacao(locacao);
    }

}
