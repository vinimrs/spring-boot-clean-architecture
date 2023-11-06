package br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway;


import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;

import java.util.List;
import java.util.Optional;

public interface RentalCompanyGateway {
    RentalCompany create(RentalCompany rentalCompany);
    RentalCompany update(RentalCompany rentalCompany);
    void delete(Long id);

    Optional<RentalCompany> findById(Long id);

    Optional<RentalCompany> findByCnpj(String cnpj);
    Optional<RentalCompany> findByName(String name);

    List<String> findAllCities();

    List<RentalCompany> findAllByCity(String city);

    List<RentalCompany> findAll();
}
