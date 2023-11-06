package br.ufscar.dc.dsw.bikerental.entity.rental.model;

import br.ufscar.dc.dsw.bikerental.entity.AbstractEntity;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rental extends AbstractEntity<Long> {
  private LocalTime hour;
  private LocalDate date;
  private RentalCompany rentalCompany;
  private Costumer client;

  public Rental(LocalTime hour, LocalDate date, RentalCompany rentalCompany, Costumer client) {
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

  public RentalCompany getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(RentalCompany rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public Costumer getClient() {
    return client;
  }

  public void setClient(Costumer client) {
    this.client = client;
  }
}
