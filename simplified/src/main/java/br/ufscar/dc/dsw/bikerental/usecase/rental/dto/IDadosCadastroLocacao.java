package br.ufscar.dc.dsw.bikerental.usecase.rental.dto;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosCadastroLocacao {

    String hour();

    String date();

    Long rentalCompanyId();

    Long clientId();
}
