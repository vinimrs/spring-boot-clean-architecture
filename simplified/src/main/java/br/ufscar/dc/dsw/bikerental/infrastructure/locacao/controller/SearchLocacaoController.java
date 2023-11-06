package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.SearchRentalsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchLocacaoController {

    private final SearchRentalsUseCase searchRentalsUseCase;

    public SearchLocacaoController(SearchRentalsUseCase searchRentalsUseCase) {
        this.searchRentalsUseCase = searchRentalsUseCase;
    }

    @GetMapping("/locacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao() {
        List<Rental> locacoes = this.searchRentalsUseCase.execute();

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
