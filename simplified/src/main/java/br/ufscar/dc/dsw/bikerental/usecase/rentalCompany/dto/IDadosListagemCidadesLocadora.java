package br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto;

import java.util.List;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosListagemCidadesLocadora {

    List<String> cities();
}
