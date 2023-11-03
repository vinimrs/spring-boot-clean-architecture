package br.ufscar.dc.dsw.locadora.usecase.locadora.dto;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosPublicosLocadora {

    String id();

    String name();

    String email();

    String city();

}
