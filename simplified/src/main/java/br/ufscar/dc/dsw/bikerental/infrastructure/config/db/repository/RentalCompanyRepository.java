package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.RentalCompanySchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RentalCompanyRepository extends JpaRepository<RentalCompanySchema, Long> {
  Optional<RentalCompanySchema> findByCnpj(String cpf);

  @Query("SELECT DISTINCT l.city FROM RentalCompanySchema l")
  List<String> findAllCities();

  List<RentalCompanySchema> findAllByCity(String city);

  Optional<RentalCompanySchema> findByName(String name);
}
