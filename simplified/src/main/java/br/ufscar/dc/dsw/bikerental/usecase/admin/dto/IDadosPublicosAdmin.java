package br.ufscar.dc.dsw.bikerental.usecase.admin.dto;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosPublicosAdmin {

    String id();

    String username();

    String name();

    String email();


}
