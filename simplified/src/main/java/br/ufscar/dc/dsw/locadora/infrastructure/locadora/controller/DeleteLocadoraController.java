package br.ufscar.dc.dsw.locadora.infrastructure.locadora.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.exception.ClienteNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.cliente.DeleteClienteUseCase;
import br.ufscar.dc.dsw.locadora.usecase.locadora.DeleteLocadoraUseCase;
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
    public DadosPublicosLocadora deleteCliente(@PathVariable Long id) throws LocadoraNotFoundException {
        return new DadosPublicosLocadora(deleteLocadoraUseCase.execute(id));
    }

}
