package br.ufscar.dc.dsw.bikerental.infrastructure.cliente.dto;

import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.dto.IDadosPublicosCliente;

public record DadosPublicosCliente(
        String id,

        String username,

        String name,

        String email,

        String phoneNumber
) implements IDadosPublicosCliente {
        public DadosPublicosCliente(Costumer costumer) {
                this(
                        costumer.getId().toString(),
                        costumer.getUsername(),
                        costumer.getName(),
                        costumer.getEmail(),
                        costumer.getPhoneNumber()
                );
        }
}