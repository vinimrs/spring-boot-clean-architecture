package br.ufscar.dc.dsw.locadora.controller;

import br.ufscar.dc.dsw.locadora.domain.Admin;
import br.ufscar.dc.dsw.locadora.dto.RetornoComMessagem;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosAtualizacaoAdmin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosCadastroAdmin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosDetalhamentoAdmin;
import br.ufscar.dc.dsw.locadora.service.spec.IAdminService;
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
@RequestMapping("/admins")
public class AdminController {

  @Autowired
  private IAdminService service;

  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<DadosDetalhamentoAdmin>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<DadosDetalhamentoAdmin> admins = service.findAll(pageable).map(DadosDetalhamentoAdmin::new);

    return ResponseEntity.ok().body(admins);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<RetornoComMessagem> cadastrar(@RequestBody @Valid DadosCadastroAdmin dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Admin admin = service.save(dados);
    URI uri = uriBuilder.path("/admins/{id}").buildAndExpand(admin.getId()).toUri();

    String message = getMessage("admins.create.success", locale);

    return ResponseEntity.created(uri).body(new RetornoComMessagem(message, new DadosDetalhamentoAdmin(admin)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoAdmin dados, final Locale locale) {
    Admin admin = service.update(id, dados);
    String message = getMessage("admins.update.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoAdmin(admin)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> deletar(@PathVariable Long id, final Locale locale) {
    Admin admin = service.delete(id);

    String message = getMessage("admins.delete.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoAdmin(admin)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DadosDetalhamentoAdmin> detalhar(@PathVariable Long id) {
    Admin admin = service.findById(id);

    return ResponseEntity.ok().body(new DadosDetalhamentoAdmin(admin));
  }
}
