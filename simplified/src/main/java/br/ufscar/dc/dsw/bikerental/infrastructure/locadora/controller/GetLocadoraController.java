package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.GetLocadoraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocadoraController {

    private final GetLocadoraUseCase getLocadoraUseCase;

    public GetLocadoraController(GetLocadoraUseCase getLocadoraUseCase) {
        this.getLocadoraUseCase = getLocadoraUseCase;
    }

    @GetMapping("/locadoras/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosLocadora getLocadora(@PathVariable Long id) throws RentalCompanyNotFoundException {
        RentalCompany rentalCompany = getLocadoraUseCase.execute(id);

        return new DadosPublicosLocadora(rentalCompany);
    }

}
