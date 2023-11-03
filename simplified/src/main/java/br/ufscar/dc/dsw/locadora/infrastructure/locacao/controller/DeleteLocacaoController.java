package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.cliente.DeleteClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.DeleteLocacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteLocacaoController {

    private final DeleteLocacaoUseCase deleteLocacaoUseCase;

    public DeleteLocacaoController(DeleteLocacaoUseCase deleteLocacaoUseCase) {
        this.deleteLocacaoUseCase = deleteLocacaoUseCase;
    }

    @DeleteMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocacao deleteLocacao(@PathVariable Long id) throws LocacaoNotFoundException {
        return new DadosPublicosLocacao(deleteLocacaoUseCase.execute(id));
    }

}
