package br.ufscar.dc.dsw.bikerental.usecase.costumer;

import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Sex;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.dto.IDadosCadastroCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateClienteUseCase {
    private final CostumerGateway costumerGateway;

    public CreateClienteUseCase(CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
    }

    public Costumer execute(IDadosCadastroCliente dados) {

        Costumer costumer = new Costumer(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cpf(), dados.phoneNumber(), Sex.valueOf(dados.sex()),
            LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return this.costumerGateway.create(costumer);
    }


}
