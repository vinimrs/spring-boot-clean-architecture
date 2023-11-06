package br.ufscar.dc.dsw.bikerental.usecase.admin.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IAdminUpdateData {

    String username();

    String password();

    String name();

    String email();

}
