package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Locadora")
public class LocadoraSchema extends UsuarioSchema {

//  @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
  @NotBlank
//  @CNPJ(message = "{Size.locadora.CNPJ}")
  @Column(unique = true)
  private String cnpj;

  @NotBlank
  @Column(length = 50)
  private String city;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rentalCompany")
  private List<LocacaoSchema> locacoes;

  public LocadoraSchema(RentalCompany rentalCompany) {
    super(rentalCompany.getId(), rentalCompany.getUsername(), rentalCompany.getName(), rentalCompany.getEmail(), rentalCompany.getPassword());
    this.cnpj = rentalCompany.getCnpj();
    this.city = rentalCompany.getCity();

    this.role = "ROLE_LOCADORA";
  }

  public LocadoraSchema() {
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

  public List<LocacaoSchema> getLocacoes() {
    return locacoes;
  }

  public RentalCompany toLocadora() {
    RentalCompany rentalCompany = new RentalCompany(
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail(),
            this.cnpj,
            this.city
    );

    rentalCompany.setId(this.getId()); // transforma o id do schema (gerado pelo banco de dados em id do cliente

    return rentalCompany;
  }

}
