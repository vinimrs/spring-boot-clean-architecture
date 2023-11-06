package br.ufscar.dc.dsw.bikerental.usecase.admin.dto;

// Interface do DTO (Data Transfer Object) para ocorrer a
// inversão de Dependencias da lib spring
public interface IAdminPublicData {

    String id();

    String username();

    String name();

    String email();


}
