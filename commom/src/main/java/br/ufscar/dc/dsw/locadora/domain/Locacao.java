package br.ufscar.dc.dsw.locadora.domain;

import br.ufscar.dc.dsw.locadora.dto.locacao.DadosCadastroLocacao;
import br.ufscar.dc.dsw.locadora.validation.classlevel.ValidLocacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@ValidLocacao(message = "{ValidLocacao.locacao}")
@Entity
@Table(name = "Locacao",
    uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "client_id"})
)
public class Locacao extends AbstractEntity<Long> {
  @NotNull
  @Column(nullable = false, columnDefinition = "Time", name = "hour")
  private LocalTime hour;

  @NotNull
  @Column(nullable = false, columnDefinition = "Date", name = "date")
  private LocalDate date;

  @NotNull(message = "{NotNull.locacao.locadora}")
  @ManyToOne
  @JoinColumn(name = "rentalCompany_id")
  private Locadora rentalCompany;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "client_id")
  private Cliente client;

  public Locacao(DadosCadastroLocacao locacao, Locadora locadora, Cliente cliente) {
    this.hour = LocalTime.parse(locacao.hour(), DateTimeFormatter.ofPattern("HH:00"));
    this.date = LocalDate.parse(locacao.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.rentalCompany = locadora;
    this.client = cliente;
  }

  public Locacao() {
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
