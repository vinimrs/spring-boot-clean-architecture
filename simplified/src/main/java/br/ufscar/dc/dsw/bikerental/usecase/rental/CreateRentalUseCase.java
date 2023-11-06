package br.ufscar.dc.dsw.bikerental.usecase.rental;

import br.ufscar.dc.dsw.bikerental.entity.customer.exception.CustomerrNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.model.Customer;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception.RentalCompanyNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IRentalRegistrationData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateRentalUseCase {
    private final CustomerGateway customerGateway;
    private final RentalCompanyGateway rentalCompanyGateway;
    private final RentalGateway rentalGateway;

    public CreateRentalUseCase(RentalGateway rentalGateway, RentalCompanyGateway rentalCompanyGateway, CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
        this.rentalCompanyGateway = rentalCompanyGateway;
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(IRentalRegistrationData dados) throws CustomerrNotFoundException, RentalCompanyNotFoundException {

        Customer customer = this.customerGateway.findById(dados.customerId())
                .orElseThrow(CustomerrNotFoundException::new);

        RentalCompany rentalCompany = this.rentalCompanyGateway.findById(dados.rentalCompanyId())
                .orElseThrow(RentalCompanyNotFoundException::new);

        Rental rental = new Rental(LocalTime.parse(dados.hour(), DateTimeFormatter.ofPattern("HH:00")),
                                        LocalDate.parse(dados.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            rentalCompany,
                customer);

        return this.rentalGateway.create(rental);
    }


}
