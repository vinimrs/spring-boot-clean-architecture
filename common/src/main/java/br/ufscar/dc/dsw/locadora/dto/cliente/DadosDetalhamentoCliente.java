package br.ufscar.dc.dsw.locadora.dto.cliente;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Sexo;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosDetalhamentoLocacaoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoCliente(
    Long id, String username, String name, String email,
    String cpf, String phoneNumber, Sexo sex,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthdate,
    List<DadosDetalhamentoLocacaoCliente> locacoes) {
  public DadosDetalhamentoCliente(Cliente cliente) {
    this(cliente.getId(), cliente.getUsername(), cliente.getName(), cliente.getEmail(),
        cliente.getCpf(), cliente.getPhoneNumber(), cliente.getSex(), cliente.getBirthdate(),
        cliente.getLocacoes() != null ? cliente.getLocacoes().stream().map(DadosDetalhamentoLocacaoCliente::new).toList() : List.of());
  }

}
