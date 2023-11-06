package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.bikerental.entity.rental.model.Rental;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

//@ValidRental(message = "{ValidRental.rental}")
@Entity
@Table(name = "Rental",
    uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "customer_id"})
)
public class RentalSchema extends AbstractEntitySchema<Long> {
  @NotNull
  @Column(nullable = false, columnDefinition = "Time", name = "hour")
  private LocalTime hour;

  @NotNull
  @Column(nullable = false, columnDefinition = "Date", name = "date")
  private LocalDate date;

  @NotNull(message = "{NotNull.rental.rentaCompany}")
  @ManyToOne
  @JoinColumn(name = "rentalCompany_id")
  private RentalCompanySchema rentalCompany;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerSchema customer;

  public RentalSchema(Rental rental) {
    this.hour = rental.getHour();
    this.date = rental.getDate();
    this.rentalCompany = new RentalCompanySchema(rental.getRentalCompany());
    this.customer = new CustomerSchema(rental.getCustomer());
  }

  public RentalSchema() {
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

  public RentalCompanySchema getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(RentalCompanySchema rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public CustomerSchema getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerSchema customer) {
    this.customer = customer;
  }

  public Rental toRental() {
    Rental rental = new Rental(
            this.hour,
            this.date,
            this.rentalCompany.toRentalCompany(),
            this.customer.toCustomer()
    );

    rental.setId(this.getId());

    return rental;
  }
}
