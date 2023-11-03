package br.ufscar.dc.dsw.locadora.infrastructure.locacao.dto;

import br.ufscar.dc.dsw.locadora.infrastructure.locacao.validation.classlevel.ValidCadastroLocacao;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.validation.formats.LocacaoDate;
import br.ufscar.dc.dsw.locadora.infrastructure.locacao.validation.formats.LocacaoHour;

import br.ufscar.dc.dsw.locadora.usecase.locacao.dto.IDadosCadastroLocacao;
import jakarta.validation.constraints.NotNull;

@ValidCadastroLocacao(message = "{ValidLocacao.locacao}")
public record DadosCadastroLocacao(
    @LocacaoHour(message = "{Hour.locacao}")
    @NotNull
    String hour,

    @LocacaoDate(message = "{Date.locacao}")
    @NotNull
    String date,

    @NotNull
    Long rentalCompanyId,

    @NotNull
    Long clientId
    ) implements IDadosCadastroLocacao { }