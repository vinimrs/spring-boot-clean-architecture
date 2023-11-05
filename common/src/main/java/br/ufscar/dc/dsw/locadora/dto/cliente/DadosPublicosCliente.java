package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.domain.Cliente;

public record DadosPublicosCliente(
    Long id, String username, String name, String email, String phoneNumber) {
  public DadosPublicosCliente(Cliente cliente) {
    this(cliente.getId(), cliente.getUsername(), cliente.getName(), cliente.getEmail(), cliente.getPhoneNumber());
  }

}
