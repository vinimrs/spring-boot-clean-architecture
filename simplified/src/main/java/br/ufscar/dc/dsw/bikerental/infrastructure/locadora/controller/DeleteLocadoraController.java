package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.DeleteLocadoraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteLocadoraController {

    private final DeleteLocadoraUseCase deleteLocadoraUseCase;

    public DeleteLocadoraController(DeleteLocadoraUseCase deleteLocadoraUseCase) {
        this.deleteLocadoraUseCase = deleteLocadoraUseCase;
    }

    @DeleteMapping("/locadoras/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocadora deleteCliente(@PathVariable Long id) throws RentalCompanyNotFoundException {
        return new DadosPublicosLocadora(deleteLocadoraUseCase.execute(id));
    }

}
