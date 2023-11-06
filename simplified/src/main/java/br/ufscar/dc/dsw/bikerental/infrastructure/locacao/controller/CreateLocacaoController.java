package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosCadastroLocacao;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.CreateRentalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateLocacaoController {

    private final CreateRentalUseCase createRentalUseCase;

    public CreateLocacaoController(CreateRentalUseCase createRentalUseCase) {
        this.createRentalUseCase = createRentalUseCase;
    }

    @PostMapping("/locacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public DadosPublicosLocacao createLocacao(@Valid @RequestBody DadosCadastroLocacao dados) throws CostumerNotFoundException, RentalCompanyNotFoundException {
        return new DadosPublicosLocacao(createRentalUseCase.execute(dados));
    }

}
