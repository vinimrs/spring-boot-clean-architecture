package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.FindLocadorasByCityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindLocadorasByCityController {

    private final FindLocadorasByCityUseCase findLocadorasByCityUseCase;

    public FindLocadorasByCityController(FindLocadorasByCityUseCase findLocadorasByCityUseCase) {
        this.findLocadorasByCityUseCase = findLocadorasByCityUseCase;
    }

    @GetMapping("/locadoras/cidades/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocadora> searchCliente(@PathVariable String city) {
        List<RentalCompany> rentalCompanies = this.findLocadorasByCityUseCase.execute(city);

        return rentalCompanies.stream().map(DadosPublicosLocadora::new).toList();
    }

}
