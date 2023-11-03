package br.ufscar.dc.dsw.locadora.service.impl;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosCadastroLocadora;
import br.ufscar.dc.dsw.locadora.repository.ILocadoraRepository;
import br.ufscar.dc.dsw.locadora.repository.IUsuarioRepository;
import br.ufscar.dc.dsw.locadora.service.spec.ILocadoraService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService {

  @Autowired
  private Validator validator;

  @Autowired
  private ILocadoraRepository repository;

  @Autowired
  private IUsuarioRepository usuarioRepository;

  public Locadora save(DadosCadastroLocadora dados) {
    Locadora locadora = new Locadora(dados);

    Set<ConstraintViolation<Locadora>> violations = validator.validate(locadora);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(locadora);
    return locadora;
  }

  public Locadora delete(Long id) {
    Locadora locadora = repository.findById(id).orElse(null);

    if (locadora == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return locadora;
  }

  @Override
  public Locadora update(Long id, DadosAtualizacaoLocadora dados) {
    Locadora locadora = repository.findById(id).orElse(null);

    if (locadora == null) {
      throw new EntityNotFoundException();
    }

    if (dados.email() != null && !dados.email().equals(locadora.getEmail())) {
      int quantidadeEmail = usuarioRepository.findAllByEmail(dados.email()).size();
      if (quantidadeEmail > 0) {
        throw new ConstraintViolationException("Email já cadastrado", Set.of(
            validator.validateProperty(locadora, "email").iterator().next()
        ));
      }
    }

    if (dados.username() != null && !dados.username().equals(locadora.getUsername())) {
      int quantidadeUsername = usuarioRepository.findAllByUsername(dados.username()).size();
      if (quantidadeUsername > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(locadora, "username").iterator().next())
        );
      }
    }

    if (dados.cnpj() != null && !dados.cnpj().equals(locadora.getCnpj())) {
      int quantidadeCpf = repository.findAllByCnpj(dados.cnpj()).size();
      if (quantidadeCpf > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(locadora, "cnpj").iterator().next())
        );
      }
    }

    locadora.atualizar(dados);

    return locadora;
  }

  @Override
  public Page<Locadora> findAllByCity(String city, Pageable pageable) {

    return repository.findAllByCity(city, pageable);
  }

  @Override
  public List<String> findAllCities() {
    return repository.findAllCities();
  }

  @Transactional(readOnly = true)
  public Locadora findById(Long id) {
    Locadora locadora = repository.findById(id).orElse(null);

    if (locadora == null) {
      throw new EntityNotFoundException();
    }

    return locadora;
  }

  @Transactional(readOnly = true)
  public Page<Locadora> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
