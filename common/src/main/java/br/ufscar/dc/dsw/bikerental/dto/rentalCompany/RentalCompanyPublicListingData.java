package br.ufscar.dc.dsw.bikerental.dto.rentalCompany;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;

public record RentalCompanyPublicListingData(
    Long id, String name, String email, String city) {
  public RentalCompanyPublicListingData(RentalCompany rentalCompany) {
    this(rentalCompany.getId(), rentalCompany.getName(), rentalCompany.getEmail(), rentalCompany.getCity());
  }

}
