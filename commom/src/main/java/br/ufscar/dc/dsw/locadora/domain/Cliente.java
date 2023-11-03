package br.ufscar.dc.dsw.locadora.domain;

import br.ufscar.dc.dsw.locadora.dto.cliente.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.BirthDate;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.CPF;
import br.ufscar.dc.dsw.locadora.validation.formats.cliente.PhoneNumber;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

  @UniqueCPF(message = "{Unique.cliente.CPF}")
  @NotBlank
  @CPF(message = "{Size.cliente.CPF}")
  @Column(unique = true)
  private String cpf;

  @NotBlank
  @PhoneNumber(message = "{Size.cliente.phone}")
  private String phoneNumber;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Sexo sex;

  @BirthDate(message = "{BirthDate.cliente}")
  @Column(columnDefinition = "Date")
  private LocalDate birthdate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
  private List<Locacao> locacoes;

  public Cliente() {
    this.role = "ROLE_CLIENTE";
  }

  public Cliente(DadosCadastroCliente dados) {
    super(dados.username(), dados.password(), dados.name(), dados.email());
    this.role = "ROLE_CLIENTE";
    this.cpf = dados.cpf();
    this.phoneNumber = dados.phoneNumber();
    this.sex = Sexo.valueOf(dados.sex());
    this.birthdate = LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

  public List<Locacao> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Locacao> locacoes) {
    this.locacoes = locacoes;
  }

  public void atualizar(DadosAtualizacaoCliente dados) {
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

    if (dados.cpf() != null && !dados.cpf().isBlank()) {
      this.setCpf(dados.cpf());
    }

    if (dados.phoneNumber() != null && !dados.phoneNumber().isBlank()) {
      this.setPhoneNumber(dados.phoneNumber());
    }

    if (dados.sex() != null && !dados.sex().isBlank()) {
      this.setSex(Sexo.valueOf(dados.sex()));
    }

    if (dados.birthdate() != null && !dados.birthdate().isBlank()) {
      this.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }


  }
}
