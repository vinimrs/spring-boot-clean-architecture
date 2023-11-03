package br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.dto.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto.DadosPublicosLocadora;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosDetalhamentoLocacaoCliente;
import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosDetalhamentoLocacaoLocadora;
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
        public DadosDetalhamentoLocacaoLocadora(Locacao locacao) {
                this(
                        locacao.getId(),
                        locacao.getHour(),
                        locacao.getDate(),
                        new DadosPublicosCliente(locacao.getClient())
                );
        }
}