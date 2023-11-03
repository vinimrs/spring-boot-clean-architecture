package br.ufscar.dc.dsw.locadora.controller;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.dto.RetornoComMessagem;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosCadastroLocacao;
import br.ufscar.dc.dsw.locadora.dto.locacao.DadosDetalhamentoLocacao;
import br.ufscar.dc.dsw.locadora.service.spec.ILocacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

  @Autowired
  private ILocacaoService service;

  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<DadosDetalhamentoLocacao>> listar(@PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<DadosDetalhamentoLocacao> locacoes = service.findAll(pageable).map(DadosDetalhamentoLocacao::new);

    return ResponseEntity.ok().body(locacoes);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<RetornoComMessagem> cadastrar(@RequestBody @Valid DadosCadastroLocacao dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Locacao locacao = service.save(dados);
    URI uri = uriBuilder.path("/locacoes/{id}").buildAndExpand(locacao.getId()).toUri();

    String message = getMessage("locacoes.create.success", locale);

    return ResponseEntity.created(uri).body(new RetornoComMessagem(message, new DadosDetalhamentoLocacao(locacao)));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> deletar(@PathVariable Long id, final Locale locale) {
    Locacao locacao = service.delete(id);

    String message = getMessage("locacoes.delete.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoLocacao(locacao)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DadosDetalhamentoLocacao> detalhar(@PathVariable Long id) {
    Locacao locacao = service.findById(id);

    return ResponseEntity.ok().body(new DadosDetalhamentoLocacao(locacao));
  }

  @GetMapping("/clientes/{id}")
  public ResponseEntity<Page<DadosDetalhamentoLocacao>> listarPorCliente(@PathVariable Long id, @PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<DadosDetalhamentoLocacao> locacoes = service.findAllByCliente(id, pageable).map(DadosDetalhamentoLocacao::new);

    return ResponseEntity.ok().body(locacoes);
  }

  @GetMapping("/locadoras/{id}")
  public ResponseEntity<Page<DadosDetalhamentoLocacao>> listarPorLocadora(@PathVariable Long id, @PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<DadosDetalhamentoLocacao> locacoes = service.findAllByLocadora(id, pageable).map(DadosDetalhamentoLocacao::new);

    return ResponseEntity.ok().body(locacoes);
  }
}
