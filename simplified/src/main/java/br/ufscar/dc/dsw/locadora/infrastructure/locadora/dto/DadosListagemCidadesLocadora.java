package br.ufscar.dc.dsw.locadora.infrastructure.locadora.dto;

import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosListagemCidadesLocadora;

import java.util.List;

public record DadosListagemCidadesLocadora(
    List<String> cities
) implements IDadosListagemCidadesLocadora { }