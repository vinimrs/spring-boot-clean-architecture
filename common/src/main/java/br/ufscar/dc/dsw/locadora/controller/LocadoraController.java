package br.ufscar.dc.dsw.locadora.controller;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.dto.RetornoComMessagem;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosCadastroLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosDetalhamentoLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosListagemCidadesLocadora;
import br.ufscar.dc.dsw.locadora.service.spec.ILocadoraService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

  @Autowired
  private ILocadoraService service;

  @Getter
  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<DadosDetalhamentoLocadora>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<DadosDetalhamentoLocadora> locadoras = service.findAll(pageable).map(DadosDetalhamentoLocadora::new);

    return ResponseEntity.ok().body(locadoras);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<RetornoComMessagem> cadastrar(@RequestBody @Valid DadosCadastroLocadora dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Locadora locadora = service.save(dados);
    URI uri = uriBuilder.path("/locadoras/{id}").buildAndExpand(locadora.getId()).toUri();

    String message = getMessage("locadoras.create.success", locale);

    return ResponseEntity.created(uri).body(new RetornoComMessagem(message, new DadosDetalhamentoLocadora(locadora)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoLocadora dados, final Locale locale) {
    Locadora locadora = service.update(id, dados);
    String message = getMessage("locadoras.update.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoLocadora(locadora)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<RetornoComMessagem> deletar(@PathVariable Long id, final Locale locale) {
    Locadora locadora = service.delete(id);

    String message = getMessage("locadoras.delete.success", locale);

    return ResponseEntity.ok().body(new RetornoComMessagem(message, new DadosDetalhamentoLocadora(locadora)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DadosDetalhamentoLocadora> detalhar(@PathVariable Long id) {
    Locadora locadora = service.findById(id);

    return ResponseEntity.ok().body(new DadosDetalhamentoLocadora(locadora));
  }

  @GetMapping("/cidades")
  public ResponseEntity<DadosListagemCidadesLocadora> listarCidades() {
    List<String> cidades = service.findAllCities();

    return ResponseEntity.ok().body(new DadosListagemCidadesLocadora(cidades));
  }

  @GetMapping("/cidades/{cidade}")
  public ResponseEntity<Page<DadosDetalhamentoLocadora>> listarTodasPorCidade(@PathVariable String cidade, @PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    // Não é necessário tratar cidade nula pois, nesse caso, não será mapeado para esse método.
    Page<DadosDetalhamentoLocadora> locadoras = service.findAllByCity(cidade, pageable).map(DadosDetalhamentoLocadora::new);

    return ResponseEntity.ok().body(locadoras);
  }
}
