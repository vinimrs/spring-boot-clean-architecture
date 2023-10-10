package br.ufscar.dc.dsw.locadora.entity.locadora.model;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.usuario.model.Usuario;

import java.util.List;

public class Locadora extends Usuario {

  private String cnpj;
  private String city;
  private List<Locacao> locacoes;

  public Locadora() {
    this.role = "ROLE_LOCADORA";
  }

  public Locadora(String username, String password, String name, String email, String cnpj, String city) {
    super(username, password, name, email);
    this.city = city;
    this.cnpj = cnpj;
    this.role = "ROLE_LOCADORA";

  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Locacao> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Locacao> locacoes) {
    this.locacoes = locacoes;
  }
}
