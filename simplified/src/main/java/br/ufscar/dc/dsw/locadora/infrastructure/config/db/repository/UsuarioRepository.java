package br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.UsuarioSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UsuarioRepository extends JpaRepository<UsuarioSchema, Long> {
  UsuarioSchema findByEmail(String email);

  UsuarioSchema findByUsername(String username);

  Collection<UsuarioSchema> findAllByEmail(String email);

  Collection<UsuarioSchema> findAllByUsername(String username);
}
