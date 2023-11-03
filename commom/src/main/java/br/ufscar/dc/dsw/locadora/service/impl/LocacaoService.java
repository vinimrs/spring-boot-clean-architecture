package br.ufscar.dc.dsw.locadora.service.impl;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosCadastroLocacao;
import br.ufscar.dc.dsw.locadora.repository.IClienteRepository;
import br.ufscar.dc.dsw.locadora.repository.ILocacaoRepository;
import br.ufscar.dc.dsw.locadora.repository.ILocadoraRepository;
import br.ufscar.dc.dsw.locadora.service.spec.ILocacaoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = false)
public class LocacaoService implements ILocacaoService {

  @Autowired
  private Validator validator;

  @Autowired
  private ILocacaoRepository repository;

  @Autowired
  private ILocadoraRepository rentalCompanyRepository;

  @Autowired
  private IClienteRepository clientRepository;

  @Transactional(readOnly = true)
  public Locacao findById(Long id) {
    Locacao locacao = repository.findById(id).orElse(null);

    if (locacao == null) {
      throw new EntityNotFoundException();
    }

    return locacao;
  }

  @Transactional(readOnly = true)
  public Page<Locacao> findAllByRentalCompany(Pageable pageable, Locadora rentalCompany) {
    return repository.findAllByRentalCompany(rentalCompany, pageable);
  }

  @Transactional(readOnly = true)
  public Page<Locacao> findAllByClient(Pageable pageable, Cliente client) {
    return repository.findAllByClient(client, pageable);
  }

  @Transactional(readOnly = true)
  public Page<Locacao> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Locacao save(DadosCadastroLocacao locacao) {
    Locadora locadora = rentalCompanyRepository.findById(locacao.rentalCompanyId()).orElse(null);
    Cliente cliente = clientRepository.findById(locacao.clientId()).orElse(null);

    if (locadora == null || cliente == null) {
      throw new EntityNotFoundException();
    }

    Locacao newLocacao = new Locacao(locacao, locadora, cliente);

    Set<ConstraintViolation<Locacao>> violations = validator.validate(newLocacao);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(newLocacao);
    return newLocacao;
  }

  @Override
  public Locacao delete(Long id) {
    Locacao locacao = repository.findById(id).orElse(null);

    if (locacao == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return locacao;
  }

  @Override
  public Page<Locacao> findAllByLocadora(Long id, Pageable pageable) {
    Locadora locadora = rentalCompanyRepository.findById(id).orElse(null);

    if (locadora == null) {
      throw new EntityNotFoundException();
    }

    return repository.findAllByRentalCompany(locadora, pageable);
  }

  @Override
  public Page<Locacao> findAllByCliente(Long id, Pageable pageable) {
    Cliente cliente = clientRepository.findById(id).orElse(null);

    if (cliente == null) {
      throw new EntityNotFoundException();
    }

    return repository.findAllByClient(cliente, pageable);
  }
}
