package br.ufscar.dc.dsw.locadora.dto.locacao;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosListagemPublicaLocadora;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoLocacaoCliente(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date, DadosListagemPublicaLocadora rentalCompany) {
  public DadosDetalhamentoLocacaoCliente(Locacao locacao) {
    this(locacao.getId(), locacao.getHour(), locacao.getDate(),
        new DadosListagemPublicaLocadora(locacao.getRentalCompany()));
  }

}
