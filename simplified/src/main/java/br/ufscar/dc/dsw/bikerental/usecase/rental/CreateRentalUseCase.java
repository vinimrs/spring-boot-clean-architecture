package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IDadosCadastroLocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateRentalUseCase {
    private final CostumerGateway costumerGateway;
    private final RentalCompanyGateway rentalCompanyGateway;
    private final RentalGateway rentalGateway;

    public CreateRentalUseCase(RentalGateway rentalGateway, RentalCompanyGateway rentalCompanyGateway, CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
        this.rentalCompanyGateway = rentalCompanyGateway;
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(IDadosCadastroLocacao dados) throws CostumerNotFoundException, RentalCompanyNotFoundException {

        Costumer costumer = this.costumerGateway.findById(dados.clientId())
                .orElseThrow(CostumerNotFoundException::new);

        RentalCompany rentalCompany = this.rentalCompanyGateway.findById(dados.rentalCompanyId())
                .orElseThrow(RentalCompanyNotFoundException::new);

        Rental rental = new Rental(LocalTime.parse(dados.hour(), DateTimeFormatter.ofPattern("HH:00")),
                                        LocalDate.parse(dados.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            rentalCompany,
            costumer);

        return this.rentalGateway.create(rental);
    }


}
