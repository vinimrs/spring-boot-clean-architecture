package br.ufscar.dc.dsw.locadora.domain;


import br.ufscar.dc.dsw.locadora.dto.admin.DadosAtualizacaoAdmin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosCadastroAdmin;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends Usuario {
  public Admin() {
    this.role = "ROLE_ADMIN";
  }

  public Admin(DadosCadastroAdmin dados) {
    super(dados.username(), dados.password(), dados.name(), dados.email());
    this.role = "ROLE_ADMIN";
  }

  public void atualizar(DadosAtualizacaoAdmin dados) {
    if (dados.username() != null && !dados.username().isBlank()) {
      this.setUsername(dados.username());
    }

    if (dados.email() != null && !dados.email().isBlank()) {
      this.setEmail(dados.email());
    }

    if (dados.password() != null && !dados.password().isBlank()) {
      this.setPassword(dados.password());
    }

    if (dados.name() != null && !dados.name().isBlank()) {
      this.setName(dados.name());
    }

  }
}
