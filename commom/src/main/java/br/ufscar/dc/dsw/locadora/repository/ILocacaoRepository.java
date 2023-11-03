package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.domain.Locadora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILocacaoRepository extends JpaRepository<Locacao, Long> {
  Page<Locacao> findAllByRentalCompany(Locadora rentalCompany, Pageable pageable);

  Page<Locacao> findAllByClient(Cliente client, Pageable pageable);

  List<Locacao> findAllByClient(Cliente client);
}
