package br.ufscar.dc.dsw.locadora.entity.usuario.model;


import br.ufscar.dc.dsw.locadora.entity.AbstractEntity;

public abstract class Usuario extends AbstractEntity<Long> {

  private String username;
  private String email;
  private String password;
  private String name;
  protected String role;
  private boolean enabled;

  public Usuario(String username, String password, String name, String email) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
    this.enabled = true;
  }

  public Usuario() {
    this.enabled = true;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}