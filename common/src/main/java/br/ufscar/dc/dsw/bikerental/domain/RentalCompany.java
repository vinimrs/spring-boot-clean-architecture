package br.ufscar.dc.dsw.bikerental.domain;

import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyRegistrationData;
import br.ufscar.dc.dsw.bikerental.validation.formats.rentalCompany.CNPJ;
import br.ufscar.dc.dsw.bikerental.validation.uniques.UniqueCNPJ;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Locadora")
public class RentalCompany extends User {

  @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
  @NotBlank
  @CNPJ(message = "{Size.locadora.CNPJ}")
  @Column(unique = true)
  private String cnpj;

  @NotBlank
  @Column(length = 50)
  private String city;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rentalCompany")
  private List<Rental> locacoes;

  public RentalCompany() {
    this.role = "ROLE_LOCADORA";
  }

  public RentalCompany(RentalCompanyRegistrationData dados) {
    this.setUsername(dados.username());
    this.setPassword(dados.password());
    this.setName(dados.name());
    this.setEmail(dados.email());
    this.cnpj = dados.cnpj();
    this.city = dados.city();
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

  public void atualizar(RentalCompanyUpdateData dados) {
    if (dados.username() != null && !dados.username().isBlank()) {
      this.setUsername(dados.username());
    }

    if (dados.password() != null && !dados.password().isBlank()) {
      this.setPassword(dados.password());
    }

    if (dados.name() != null && !dados.name().isBlank()) {
      this.setName(dados.name());
    }

    if (dados.email() != null && !dados.email().isBlank()) {
      this.setEmail(dados.email());
    }

    if (dados.cnpj() != null && !dados.cnpj().isBlank()) {
      this.cnpj = dados.cnpj();
    }

    if (dados.city() != null && !dados.city().isBlank()) {
      this.city = dados.city();
    }
  }
}
