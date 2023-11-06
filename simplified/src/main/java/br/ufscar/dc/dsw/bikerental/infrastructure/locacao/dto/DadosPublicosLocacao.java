package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IDadosPublicosLocacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosPublicosLocacao(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    DadosPublicosLocadora rentalCompany,

    DadosPublicosCliente client
) implements IDadosPublicosLocacao {
        public DadosPublicosLocacao(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new DadosPublicosLocadora(rental.getRentalCompany()),
                        new DadosPublicosCliente(rental.getClient())
                );
        }
}