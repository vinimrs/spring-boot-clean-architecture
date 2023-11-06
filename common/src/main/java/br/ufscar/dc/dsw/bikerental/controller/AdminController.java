package br.ufscar.dc.dsw.bikerental.controller;

import br.ufscar.dc.dsw.bikerental.domain.Admin;
import br.ufscar.dc.dsw.bikerental.dto.ReturnWIthMessage;
import br.ufscar.dc.dsw.bikerental.dto.admin.AdminUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.admin.AdminRegistrationData;
import br.ufscar.dc.dsw.bikerental.dto.admin.AdminDetails;
import br.ufscar.dc.dsw.bikerental.service.spec.IAdminService;
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
  public ResponseEntity<Page<AdminDetails>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<AdminDetails> admins = service.findAll(pageable).map(AdminDetails::new);

    return ResponseEntity.ok().body(admins);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ReturnWIthMessage> cadastrar(@RequestBody @Valid AdminRegistrationData dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Admin admin = service.save(dados);
    URI uri = uriBuilder.path("/admins/{id}").buildAndExpand(admin.getId()).toUri();

    String message = getMessage("admins.create.success", locale);

    return ResponseEntity.created(uri).body(new ReturnWIthMessage(message, new AdminDetails(admin)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> atualizar(@PathVariable Long id, @RequestBody @Valid AdminUpdateData dados, final Locale locale) {
    Admin admin = service.update(id, dados);
    String message = getMessage("admins.update.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new AdminDetails(admin)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> deletar(@PathVariable Long id, final Locale locale) {
    Admin admin = service.delete(id);

    String message = getMessage("admins.delete.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new AdminDetails(admin)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdminDetails> detalhar(@PathVariable Long id) {
    Admin admin = service.findById(id);

    return ResponseEntity.ok().body(new AdminDetails(admin));
  }
}
