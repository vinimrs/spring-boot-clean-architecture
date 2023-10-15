package br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.CPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
  private Sexo sex;

//  @BirthDate(message = "{BirthDate.cliente}")
  @Column(columnDefinition = "Date")
  private LocalDate birthdate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
  private List<LocacaoSchema> locacoes;

  public ClienteSchema() {
    this.role = "ROLE_CLIENTE";
  }


  public ClienteSchema(Cliente cliente) {
    super(cliente.getId(), cliente.getUsername(), cliente.getName(), cliente.getEmail(), cliente.getPassword());
    this.cpf = cliente.getCpf();
    this.phoneNumber = cliente.getPhoneNumber();
    this.sex = cliente.getSex();
    this.birthdate = cliente.getBirthdate();

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

  public Sexo getSex() {
    return sex;
  }

  public void setSex(Sexo sex) {
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

  public Cliente toCliente() {
    Cliente cliente = new Cliente(
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail(),
            this.cpf,
            this.phoneNumber,
            this.sex,
            this.birthdate
    );
    cliente.setId(this.getId()); // transforma o id do schema (gerado pelo banco de dados em id do cliente
    return cliente;
  }
}
