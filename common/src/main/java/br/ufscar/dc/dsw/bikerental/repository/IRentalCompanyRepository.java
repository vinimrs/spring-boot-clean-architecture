package br.ufscar.dc.dsw.bikerental.repository;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRentalCompanyRepository extends JpaRepository<RentalCompany, Long> {
  List<RentalCompany> findAllByCnpj(String cnpj);

  RentalCompany findByCnpj(String cnpj);

  @Query("SELECT DISTINCT l.city FROM RentalCompany l")
  List<String> findAllCities();

  Page<RentalCompany> findAllByCity(String city, Pageable pageable);
}
