package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.ListRentalsByRentalCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListLocacoesByLocadoraController {

    private final ListRentalsByRentalCompanyUseCase listLocacoesUseCase;

    public ListLocacoesByLocadoraController(ListRentalsByRentalCompanyUseCase listLocacoesUseCase) {
        this.listLocacoesUseCase = listLocacoesUseCase;
    }

    @GetMapping("/locacoes/locadoras/{locadoraId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao(@PathVariable Long locadoraId) throws RentalNotFoundException, RentalCompanyNotFoundException {
        List<Rental> locacoes = this.listLocacoesUseCase.execute(locadoraId);

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
