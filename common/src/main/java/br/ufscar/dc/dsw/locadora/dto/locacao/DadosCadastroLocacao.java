package br.ufscar.dc.dsw.locadora.dto.locacao;

import br.ufscar.dc.dsw.locadora.validation.classlevel.ValidCadastroLocacao;
import br.ufscar.dc.dsw.locadora.validation.formats.locacao.LocacaoDate;
import br.ufscar.dc.dsw.locadora.validation.formats.locacao.LocacaoHour;
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
    Long clientId) {
}
