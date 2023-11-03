package br.ufscar.dc.dsw.locadora.entity.admin.model;


import br.ufscar.dc.dsw.locadora.entity.usuario.model.Usuario;

public class Admin extends Usuario {
  public Admin() {
    this.role = "ROLE_ADMIN";
  }

public Admin(String username, String password, String name, String email) {
    super(username, password, name, email);
    this.role = "ROLE_ADMIN";
  }
}
