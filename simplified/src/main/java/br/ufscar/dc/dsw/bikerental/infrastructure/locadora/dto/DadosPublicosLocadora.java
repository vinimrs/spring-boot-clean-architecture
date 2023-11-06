package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.model.RentalCompany;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosPublicosLocadora;

public record DadosPublicosLocadora(
        String id,

        String username,

        String name,

        String email,

        String city
) implements IDadosPublicosLocadora {
        public DadosPublicosLocadora(RentalCompany rentalCompany) {
                this(
                        rentalCompany.getId().toString(),
                        rentalCompany.getUsername(),
                        rentalCompany.getName(),
                        rentalCompany.getEmail(),
                        rentalCompany.getCity()
                );
        }

}