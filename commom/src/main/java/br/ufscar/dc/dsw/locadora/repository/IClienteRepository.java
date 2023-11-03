package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
  Cliente findByCpf(String cpf);

  Collection<Cliente> findAllByCpf(String cpf);
}
