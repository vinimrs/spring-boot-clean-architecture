package br.ufscar.dc.dsw.locadora.usecase.locacao.dto;

import br.ufscar.dc.dsw.locadora.usecase.cliente.dto.IDadosPublicosCliente;

import java.time.LocalDate;
import java.time.LocalTime;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosDetalhamentoLocacaoLocadora {

    Long id();

    LocalTime hour();

    LocalDate date();

    IDadosPublicosCliente client();

}
