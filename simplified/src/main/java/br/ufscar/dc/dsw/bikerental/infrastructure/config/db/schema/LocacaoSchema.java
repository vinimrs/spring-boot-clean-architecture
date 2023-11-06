package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

//@ValidLocacao(message = "{ValidLocacao.locacao}")
@Entity
@Table(name = "Locacao",
    uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "client_id"})
)
public class LocacaoSchema extends AbstractEntitySchema<Long> {
  @NotNull
  @Column(nullable = false, columnDefinition = "Time", name = "hour")
  private LocalTime hour;

  @NotNull
  @Column(nullable = false, columnDefinition = "Date", name = "date")
  private LocalDate date;

  @NotNull(message = "{NotNull.locacao.locadora}")
  @ManyToOne
  @JoinColumn(name = "rentalCompany_id")
  private LocadoraSchema rentalCompany;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClienteSchema client;

  public LocacaoSchema(Rental rental) {
    this.hour = rental.getHour();
    this.date = rental.getDate();
    this.rentalCompany = new LocadoraSchema(rental.getRentalCompany());
    this.client = new ClienteSchema(rental.getClient());
  }

  public LocacaoSchema() {
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

  public LocadoraSchema getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(LocadoraSchema rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public ClienteSchema getClient() {
    return client;
  }

  public void setClient(ClienteSchema client) {
    this.client = client;
  }

  public Rental toLocacao() {
    Rental rental = new Rental(
            this.hour,
            this.date,
            this.rentalCompany.toLocadora(),
            this.client.toCliente()
    );

    rental.setId(this.getId());

    return rental;
  }
}
