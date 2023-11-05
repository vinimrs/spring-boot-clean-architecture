package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILocadoraRepository extends JpaRepository<Locadora, Long> {
  List<Locadora> findAllByCnpj(String cnpj);

  Locadora findByCnpj(String cnpj);

  @Query("SELECT DISTINCT l.city FROM Locadora l")
  List<String> findAllCities();

  Page<Locadora> findAllByCity(String city, Pageable pageable);
}
