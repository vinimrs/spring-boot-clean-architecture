package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.UpdateLocadoraUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateLocadoraController {

    private final UpdateLocadoraUseCase updateLocadoraUseCase;

    public UpdateLocadoraController(UpdateLocadoraUseCase updateLocadoraUseCase) {
        this.updateLocadoraUseCase = updateLocadoraUseCase;
    }

    @PutMapping("/locadoras/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocadora updateLocadora(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoLocadora dados) throws RentalCompanyNotFoundException {
        return new DadosPublicosLocadora(updateLocadoraUseCase.execute(id, dados));
    }

}
