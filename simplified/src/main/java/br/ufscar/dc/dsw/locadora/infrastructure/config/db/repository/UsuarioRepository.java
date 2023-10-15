package br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.UsuarioSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioSchema, Long> {
  Optional<UsuarioSchema> findByEmail(String email);

  Optional<UsuarioSchema> findByUsername(String username);

  Collection<UsuarioSchema> findAllByEmail(String email);

  Collection<UsuarioSchema> findAllByUsername(String username);
}
