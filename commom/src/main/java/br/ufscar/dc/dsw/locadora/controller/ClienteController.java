package br.ufscar.dc.dsw.locadora.controller;

import br.ufscar.dc.dsw.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.dto.RetornoComMessagem;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosDetalhamentoCliente;
import br.ufscar.dc.dsw.locadora.service.spec.IClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private IClienteService service;

  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<DadosDetalhamentoCliente>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<DadosDetalhamentoCliente> clientes = service.findAll(pageable).map(DadosDetalhamentoCliente::new);

    return ResponseEntity.ok().body(clientes);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<RetornoComMessagem> cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Cliente cliente = service.save(dados);
    URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

    String message = getMessage("clientes.create.success", locale);

    return ResponseEntity.created(uri).body(new RetornoComMessagem(message, new DadosDetalhamentoCliente(cliente)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoCliente dados, final Locale locale) {
    Cliente cliente = service.update(id, dados);
    String message = getMessage("clientes.update.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoCliente(cliente)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> deletar(@PathVariable Long id, final Locale locale) {
    Cliente cliente = service.delete(id);

    String message = getMessage("clientes.delete.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoCliente(cliente)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DadosDetalhamentoCliente> detalhar(@PathVariable Long id) {
    Cliente cliente = service.findById(id);

    return ResponseEntity.ok().body(new DadosDetalhamentoCliente(cliente));
  }
}
