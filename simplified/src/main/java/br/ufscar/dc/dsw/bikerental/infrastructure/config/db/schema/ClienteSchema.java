package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Sex;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.validation.formats.CPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class ClienteSchema extends UsuarioSchema {

//  @UniqueCPF(message = "{Unique.cliente.CPF}")
  @NotBlank
  @CPF(message = "{Size.cliente.CPF}")
  @Column(unique = true)
  private String cpf;

  @NotBlank
//  @PhoneNumber(message = "{Size.cliente.phone}")
  private String phoneNumber;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Sex sex;

//  @BirthDate(message = "{BirthDate.cliente}")
  @Column(columnDefinition = "Date")
  private LocalDate birthdate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
  private List<LocacaoSchema> locacoes;

  public ClienteSchema() {
    this.role = "ROLE_CLIENTE";
  }


  public ClienteSchema(Costumer costumer) {
    super(costumer.getId(), costumer.getUsername(), costumer.getName(), costumer.getEmail(), costumer.getPassword());
    this.cpf = costumer.getCpf();
    this.phoneNumber = costumer.getPhoneNumber();
    this.sex = costumer.getSex();
    this.birthdate = costumer.getBirthdate();

    this.role = "ROLE_CLIENTE";
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public List<LocacaoSchema> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<LocacaoSchema> locacoes) {
    this.locacoes = locacoes;
  }

  public Costumer toCliente() {
    Costumer costumer = new Costumer(
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail(),
            this.cpf,
            this.phoneNumber,
            this.sex,
            this.birthdate
    );
    costumer.setId(this.getId()); // transforma o id do schema (gerado pelo banco de dados em id do cliente
    return costumer;
  }
}
