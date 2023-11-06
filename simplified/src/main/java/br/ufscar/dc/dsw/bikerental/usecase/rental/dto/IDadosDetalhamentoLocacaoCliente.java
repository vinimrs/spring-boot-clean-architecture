package br.ufscar.dc.dsw.bikerental.usecase.rental.dto;

import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosPublicosLocadora;

import java.time.LocalDate;
import java.time.LocalTime;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosDetalhamentoLocacaoCliente {

    Long id();

    LocalTime hour();

    LocalDate date();

    IDadosPublicosLocadora rentalCompany();


}
