package br.ufscar.dc.dsw.bikerental.dto.rentalCompany;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalDetailsRentalCompany;

import java.util.List;

public record RentalCompanyDetails(
    Long id, String username, String name, String email,
    String cnpj, String city, List<RentalDetailsRentalCompany> locacoes) {
  public RentalCompanyDetails(RentalCompany rentalCompany) {
    this(rentalCompany.getId(), rentalCompany.getUsername(), rentalCompany.getName(), rentalCompany.getEmail(),
        rentalCompany.getCnpj(), rentalCompany.getCity(),
        rentalCompany.getLocacoes() != null ? rentalCompany.getLocacoes().stream().map(RentalDetailsRentalCompany::new).toList() : List.of());
  }

}
