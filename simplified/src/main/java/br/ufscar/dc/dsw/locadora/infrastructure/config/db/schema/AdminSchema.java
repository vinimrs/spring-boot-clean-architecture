package br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.locadora.entity.admin.model.Admin;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Cliente;
import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.validation.formats.CPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Admin")
public class AdminSchema extends UsuarioSchema {

  public AdminSchema() {
    this.role = "ROLE_ADMIN";
  }

  public AdminSchema(Admin admin) {
    super(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail(), admin.getPassword());

    this.role = "ROLE_ADMIN";
  }

  public Admin toAdmin() {
    Admin admin = new Admin (
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail()
    );

    admin.setId(this.getId()); // transforma o id do schema (gerado pelo banco de dados em id do cliente

    return admin;
  }
}
