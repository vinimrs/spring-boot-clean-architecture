package br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LocadoraRepository extends JpaRepository<LocadoraSchema, Long> {
  Optional<LocadoraSchema> findByCnpj(String cpf);

  @Query("SELECT DISTINCT l.city FROM LocadoraSchema l")
  List<String> findAllCities();

  List<LocadoraSchema> findAllByCity(String city);

  Optional<LocadoraSchema> findByName(String name);
}
