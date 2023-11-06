package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.GetRentalUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocacaoController {

    private final GetRentalUseCase getRentalUseCase;

    public GetLocacaoController(GetRentalUseCase getRentalUseCase) {
        this.getRentalUseCase = getRentalUseCase;
    }

    @GetMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocacao getLocacao(@PathVariable Long id) throws RentalNotFoundException {
        Rental rental = getRentalUseCase.execute(id);

        return new DadosPublicosLocacao(rental);
    }

}
