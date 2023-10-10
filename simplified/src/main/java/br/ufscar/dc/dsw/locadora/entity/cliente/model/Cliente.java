package br.ufscar.dc.dsw.locadora.entity.cliente.model;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import br.ufscar.dc.dsw.locadora.entity.usuario.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class Cliente extends Usuario {

  private String cpf;
  private String phoneNumber;
  private Sexo sex;
  private LocalDate birthdate;
  private List<Locacao> locacoes;

  public Cliente(String username, String password, String name, String email, String cpf, String phoneNumber, Sexo sex, LocalDate birthdate) {
    super(username, password, name, email);
    this.cpf = cpf;
    this.phoneNumber = phoneNumber;
    this.sex = sex;
    this.birthdate = birthdate;
  }

  public Cliente() {
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

  public List<Locacao> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Locacao> locacoes) {
    this.locacoes = locacoes;
  }

}
