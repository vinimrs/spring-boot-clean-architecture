package br.ufscar.dc.dsw.locadora.usecase.locacao.dto;

import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosPublicosLocadora;

import java.time.LocalDate;
import java.time.LocalTime;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosPublicosLocacao {

    Long id();

    LocalTime hour();

    LocalDate date();

    IDadosPublicosLocadora rentalCompany();

    IDadosPublicosCliente client();

}
