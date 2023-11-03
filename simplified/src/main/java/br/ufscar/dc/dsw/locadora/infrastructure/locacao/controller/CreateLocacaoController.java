package br.ufscar.dc.dsw.locadora.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locacao.exception.LocacaoNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosCadastroLocacao;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locacao.CreateLocacaoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateLocacaoController {

    private final CreateLocacaoUseCase createLocacaoUseCase;

    public CreateLocacaoController(CreateLocacaoUseCase createLocacaoUseCase) {
        this.createLocacaoUseCase = createLocacaoUseCase;
    }

    @PostMapping("/locacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosLocacao createLocacao(@Valid @RequestBody DadosCadastroLocacao dados) throws ClienteNotFoundException, LocadoraNotFoundException {
        return new DadosPublicosLocacao(createLocacaoUseCase.execute(dados));
    }

}
