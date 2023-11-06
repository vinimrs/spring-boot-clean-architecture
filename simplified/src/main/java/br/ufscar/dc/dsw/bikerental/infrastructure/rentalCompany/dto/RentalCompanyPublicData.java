package br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.dto;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IRentalCompanyPublicData;

public record RentalCompanyPublicData(
        String id,

        String username,

        String name,

        String email,

        String city
) implements IRentalCompanyPublicData {
        public RentalCompanyPublicData(RentalCompany rentalCompany) {
                this(
                        rentalCompany.getId().toString(),
                        rentalCompany.getUsername(),
                        rentalCompany.getName(),
                        rentalCompany.getEmail(),
                        rentalCompany.getCity()
                );
        }

}