package br.ufscar.dc.dsw.locadora.entity.locacao.model;

import br.ufscar.dc.dsw.locadora.entity.AbstractEntity;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Locacao extends AbstractEntity<Long> {
  private LocalTime hour;
  private LocalDate date;
  private Locadora rentalCompany;
  private Cliente client;

  public Locacao(LocalTime hour, LocalDate date, Locadora rentalCompany, Cliente client) {
    this.client = client;
    this.hour = hour;
    this.date = date;
    this.rentalCompany = rentalCompany;
  }

    public LocalTime getHour() {
    return hour;
  }

  public void setHour(LocalTime hour) {
    this.hour = hour;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Locadora getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(Locadora rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public Cliente getClient() {
    return client;
  }

  public void setClient(Cliente client) {
    this.client = client;
  }
}
