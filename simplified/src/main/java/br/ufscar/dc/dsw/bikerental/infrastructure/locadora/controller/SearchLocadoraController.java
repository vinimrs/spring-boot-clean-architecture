package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.SearchLocadoraUseCase;
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
        List<RentalCompany> rentalCompanies = this.searchLocadoraUseCase.execute();

        return rentalCompanies.stream().map(DadosPublicosLocadora::new).toList();
    }

}
