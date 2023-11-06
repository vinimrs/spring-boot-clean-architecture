package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.CustomerSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalSchema;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalCompanySchema;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalSchema, Long> {
  List<RentalSchema> findAllByRentalCompany(@NotNull(message = "{NotNull.rental.rentalCompany}") RentalCompanySchema rentalCompany);

  List<RentalSchema> findAllByCustomer(@NotNull CustomerSchema customer);
}
