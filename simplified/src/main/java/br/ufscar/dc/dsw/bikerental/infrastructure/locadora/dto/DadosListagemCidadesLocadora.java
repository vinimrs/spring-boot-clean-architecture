package br.ufscar.dc.dsw.bikerental.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.dto.IDadosListagemCidadesLocadora;

import java.util.List;

public record DadosListagemCidadesLocadora(
    List<String> cities
) implements IDadosListagemCidadesLocadora { }