package br.ufscar.dc.dsw.locadora.dto.locadora;

import br.ufscar.dc.dsw.locadora.domain.Locadora;

public record DadosListagemPublicaLocadora(
    Long id, String name, String email, String city) {
  public DadosListagemPublicaLocadora(Locadora locadora) {
    this(locadora.getId(), locadora.getName(), locadora.getEmail(), locadora.getCity());
  }

}
