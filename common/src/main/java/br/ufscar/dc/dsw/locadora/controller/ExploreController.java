package br.ufscar.dc.dsw.locadora.controller;

import br.ufscar.dc.dsw.locadora.dto.locadora.DadosListagemPublicaLocadora;
import br.ufscar.dc.dsw.locadora.service.spec.ILocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explorar")
public class ExploreController {

  @Autowired
  private ILocadoraService service;

  @GetMapping
  public ResponseEntity<Page<DadosListagemPublicaLocadora>> listar(@RequestParam(required = false) String city,
                                                                   @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
    Page<DadosListagemPublicaLocadora> locadoras;
    if (city != null && !city.isEmpty()) {
      locadoras = service.findAllByCity(city, pageable).map(DadosListagemPublicaLocadora::new);
    } else {
      locadoras = service.findAll(pageable).map(DadosListagemPublicaLocadora::new);
    }

    return ResponseEntity.ok().body(locadoras);
  }


}
