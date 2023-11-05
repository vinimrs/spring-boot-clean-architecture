package br.ufscar.dc.dsw.locadora.dto.locacao;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosPublicosCliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoLocacaoLocadora(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,
    DadosPublicosCliente client) {
  public DadosDetalhamentoLocacaoLocadora(Locacao locacao) {
    this(locacao.getId(), locacao.getHour(), locacao.getDate(), new DadosPublicosCliente(locacao.getClient()));
  }

}
