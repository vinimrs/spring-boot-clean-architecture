package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByEmail(String email);

  Usuario findByUsername(String username);

  Collection<Usuario> findAllByEmail(String email);

  Collection<Usuario> findAllByUsername(String username);
}
