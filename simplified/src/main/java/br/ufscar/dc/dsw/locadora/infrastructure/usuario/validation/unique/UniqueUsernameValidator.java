package br.ufscar.dc.dsw.locadora.infrastructure.usuario.validation.unique;

import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.UsuarioRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.UsuarioSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  @Autowired
  private UsuarioRepository repository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<UsuarioSchema> usuario = repository.findByUsername(username);
      return usuario.isEmpty();
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
    }
    return true;
  }
}