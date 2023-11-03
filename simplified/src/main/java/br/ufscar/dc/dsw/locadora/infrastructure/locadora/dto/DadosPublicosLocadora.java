package br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosPublicosLocadora;

public record DadosPublicosLocadora(
        String id,

        String username,

        String name,

        String email,

        String city
) implements IDadosPublicosLocadora {
        public DadosPublicosLocadora(Locadora locadora) {
                this(
                        locadora.getId().toString(),
                        locadora.getUsername(),
                        locadora.getName(),
                        locadora.getEmail(),
                        locadora.getCity()
                );
        }

}