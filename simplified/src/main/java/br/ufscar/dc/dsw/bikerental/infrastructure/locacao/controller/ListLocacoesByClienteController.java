package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.controller;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.exception.RentalNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto.DadosPublicosLocacao;
import br.ufscar.dc.dsw.bikerental.usecase.rental.ListRentalsByCostumerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListLocacoesByClienteController {

    private final ListRentalsByCostumerUseCase listLocacoesUseCase;

    public ListLocacoesByClienteController(ListRentalsByCostumerUseCase listLocacoesUseCase) {
        this.listLocacoesUseCase = listLocacoesUseCase;
    }

    @GetMapping("/locacoes/clientes/{clienteId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DadosPublicosLocacao> searchLocacao(@PathVariable Long clienteId) throws RentalNotFoundException, CostumerNotFoundException {
        List<Rental> locacoes = this.listLocacoesUseCase.execute(clienteId);

        return locacoes.stream().map(DadosPublicosLocacao::new).toList();
    }

}
