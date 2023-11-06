package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IDadosDetalhamentoLocacaoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoLocacaoCliente(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    DadosPublicosLocadora rentalCompany
) implements IDadosDetalhamentoLocacaoCliente {
        public DadosDetalhamentoLocacaoCliente(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new DadosPublicosLocadora(rental.getRentalCompany())
                );
        }
}