package br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosDetalhamentoLocacaoCliente;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosPublicosLocacao;
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
        public DadosDetalhamentoLocacaoCliente(Locacao locacao) {
                this(
                        locacao.getId(),
                        locacao.getHour(),
                        locacao.getDate(),
                        new DadosPublicosLocadora(locacao.getRentalCompany())
                );
        }
}