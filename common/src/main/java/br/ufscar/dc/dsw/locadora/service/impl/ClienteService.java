package br.ufscar.dc.dsw.locadora.service.impl;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.repository.IClienteRepository;
import br.ufscar.dc.dsw.locadora.repository.IUsuarioRepository;
import br.ufscar.dc.dsw.locadora.service.spec.IClienteService;
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
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {

  @Autowired
  private Validator validator;

  @Autowired
  private IClienteRepository repository;

  @Autowired
  private IUsuarioRepository usuarioRepository;

  public Cliente save(DadosCadastroCliente dados) {
    Cliente cliente = new Cliente(dados);

    Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(cliente);
    return cliente;
  }

  public Cliente delete(Long id) {
    Cliente cliente = repository.findById(id).orElse(null);

    if (cliente == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return cliente;
  }

  @Transactional(readOnly = true)
  public Cliente update(Long id, DadosAtualizacaoCliente dados) {
    Cliente cliente = repository.findById(id).orElse(null);

    if (cliente == null) {
      throw new EntityNotFoundException();
    }

    if (dados.email() != null && !dados.email().equals(cliente.getEmail())) {
      int quantidadeEmail = usuarioRepository.findAllByEmail(dados.email()).size();
      if (quantidadeEmail > 0) {
        throw new ConstraintViolationException("Email já cadastrado", Set.of(
            validator.validateProperty(cliente, "email").iterator().next()
        ));
      }
    }

    if (dados.username() != null && !dados.username().equals(cliente.getUsername())) {
      int quantidadeUsername = usuarioRepository.findAllByUsername(dados.username()).size();
      if (quantidadeUsername > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(cliente, "username").iterator().next())
        );
      }
    }

    if (dados.cpf() != null && !dados.cpf().equals(cliente.getCpf())) {
      int quantidadeCpf = repository.findAllByCpf(dados.cpf()).size();
      if (quantidadeCpf > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(cliente, "cpf").iterator().next())
        );
      }
    }

    cliente.atualizar(dados);

    return cliente;
  }

  @Transactional(readOnly = true)
  public Cliente findById(Long id) {
    Cliente cliente = repository.findById(id).orElse(null);

    if (cliente == null) {
      throw new EntityNotFoundException();
    }

    return cliente;
  }

  @Transactional(readOnly = true)
  public Page<Cliente> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
