package br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique;

import br.ufscar.dc.dsw.locadora.domain.Usuario;
import br.ufscar.dc.dsw.locadora.repository.IUsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  @Autowired
  private IUsuarioRepository repository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (repository != null) {
      Usuario usuario = repository.findByUsername(username);
      return usuario == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
    }
    return true;
  }
}