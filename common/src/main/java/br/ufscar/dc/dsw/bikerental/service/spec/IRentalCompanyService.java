package br.ufscar.dc.dsw.bikerental.service.spec;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRentalCompanyService {

  RentalCompany findById(Long id);

  Page<RentalCompany> findAll(Pageable pageable);

  RentalCompany save(RentalCompanyRegistrationData locadora);

  RentalCompany delete(Long id);

  RentalCompany update(Long id, RentalCompanyUpdateData dados);

  Page<RentalCompany> findAllByCity(String city, Pageable pageable);

  List<String> findAllCities();
}
