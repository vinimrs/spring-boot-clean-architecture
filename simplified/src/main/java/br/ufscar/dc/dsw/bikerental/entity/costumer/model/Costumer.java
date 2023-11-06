package br.ufscar.dc.dsw.bikerental.entity.costumer.model;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import br.ufscar.dc.dsw.bikerental.entity.user.model.User;

import java.time.LocalDate;
import java.util.List;

public class Costumer extends User {

  private String cpf;
  private String phoneNumber;
  private Sex sex;
  private LocalDate birthdate;
  private List<Rental> locacoes;

  public Costumer(String username, String password, String name, String email, String cpf, String phoneNumber, Sex sex, LocalDate birthdate) {
    super(username, password, name, email);
    this.cpf = cpf;
    this.phoneNumber = phoneNumber;
    this.sex = sex;
    this.birthdate = birthdate;
  }

  public Costumer() {
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

  public List<Rental> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Rental> locacoes) {
    this.locacoes = locacoes;
  }

}
