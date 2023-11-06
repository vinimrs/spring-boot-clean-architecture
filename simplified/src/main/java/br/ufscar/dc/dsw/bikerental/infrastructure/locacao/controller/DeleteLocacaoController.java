package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.DeleteRentalUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteLocacaoController {

    private final DeleteRentalUseCase deleteRentalUseCase;

    public DeleteLocacaoController(DeleteRentalUseCase deleteRentalUseCase) {
        this.deleteRentalUseCase = deleteRentalUseCase;
    }

    @DeleteMapping("/locacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DadosPublicosLocacao deleteLocacao(@PathVariable Long id) throws RentalNotFoundException {
        return new DadosPublicosLocacao(deleteRentalUseCase.execute(id));
    }

}
