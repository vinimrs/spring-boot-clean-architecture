package br.ufscar.dc.dsw.bikerental.infrastructure.user.validation.unique;

import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.UserRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.schema.UserSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  @Autowired
  private UserRepository repository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<UserSchema> usuario = repository.findByUsername(username);
      return usuario.isEmpty();
    }

    return true;
  }
}