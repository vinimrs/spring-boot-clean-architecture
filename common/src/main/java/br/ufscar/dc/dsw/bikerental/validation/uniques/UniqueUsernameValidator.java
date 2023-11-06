package br.ufscar.dc.dsw.bikerental.validation.uniques;

import br.ufscar.dc.dsw.bikerental.domain.User;
import br.ufscar.dc.dsw.bikerental.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  @Autowired
  private IUserRepository repository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (repository != null) {
      User user = repository.findByUsername(username);
      return user == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
    }
    return true;
  }
}