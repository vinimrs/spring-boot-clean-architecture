package br.ufscar.dc.dsw.bikerental.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.bikerental.usecase.rental.dto.IDadosDetalhamentoLocacaoLocadora;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoLocacaoLocadora(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    DadosPublicosCliente client
) implements IDadosDetalhamentoLocacaoLocadora {
        public DadosDetalhamentoLocacaoLocadora(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new DadosPublicosCliente(rental.getClient())
                );
        }
}