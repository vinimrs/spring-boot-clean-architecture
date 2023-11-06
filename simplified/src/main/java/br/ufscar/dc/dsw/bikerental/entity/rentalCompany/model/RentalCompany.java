package br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.user.model.User;

import java.util.List;

public class RentalCompany extends User {

  private String cnpj;
  private String city;
  private List<Rental> locacoes;

  public RentalCompany() {
    this.role = "ROLE_LOCADORA";
  }

  public RentalCompany(String username, String password, String name, String email, String cnpj, String city) {
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

  public List<Rental> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Rental> locacoes) {
    this.locacoes = locacoes;
  }
}
