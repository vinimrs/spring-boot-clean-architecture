package br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocacaoSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.LocadoraSchema;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocacaoRepository extends JpaRepository<LocacaoSchema, Long> {
  List<LocacaoSchema> findAllByRentalCompany(@NotNull(message = "{NotNull.locacao.locadora}") LocadoraSchema rentalCompany);

  List<LocacaoSchema> findAllByClient(@NotNull ClienteSchema client);
}
