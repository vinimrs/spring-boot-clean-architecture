package br.ufscar.dc.dsw.bikerental.controller;

import br.ufscar.dc.dsw.bikerental.domain.RentalCompany;
import br.ufscar.dc.dsw.bikerental.dto.ReturnWIthMessage;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyRegistrationData;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyDetails;
import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyListingCitiesData;
import br.ufscar.dc.dsw.bikerental.service.spec.IRentalCompanyService;
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
public class RentalCompanyController {

  @Autowired
  private IRentalCompanyService service;

  @Getter
  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<RentalCompanyDetails>> listar(@PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    Page<RentalCompanyDetails> locadoras = service.findAll(pageable).map(RentalCompanyDetails::new);

    return ResponseEntity.ok().body(locadoras);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ReturnWIthMessage> cadastrar(@RequestBody @Valid RentalCompanyRegistrationData dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    RentalCompany rentalCompany = service.save(dados);
    URI uri = uriBuilder.path("/locadoras/{id}").buildAndExpand(rentalCompany.getId()).toUri();

    String message = getMessage("locadoras.create.success", locale);

    return ResponseEntity.created(uri).body(new ReturnWIthMessage(message, new RentalCompanyDetails(rentalCompany)));
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> atualizar(@PathVariable Long id, @RequestBody @Valid RentalCompanyUpdateData dados, final Locale locale) {
    RentalCompany rentalCompany = service.update(id, dados);
    String message = getMessage("locadoras.update.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new RentalCompanyDetails(rentalCompany)));
  }


  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> deletar(@PathVariable Long id, final Locale locale) {
    RentalCompany rentalCompany = service.delete(id);

    String message = getMessage("locadoras.delete.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new RentalCompanyDetails(rentalCompany)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RentalCompanyDetails> detalhar(@PathVariable Long id) {
    RentalCompany rentalCompany = service.findById(id);

    return ResponseEntity.ok().body(new RentalCompanyDetails(rentalCompany));
  }

  @GetMapping("/cidades")
  public ResponseEntity<RentalCompanyListingCitiesData> listarCidades() {
    List<String> cidades = service.findAllCities();

    return ResponseEntity.ok().body(new RentalCompanyListingCitiesData(cidades));
  }

  @GetMapping("/cidades/{cidade}")
  public ResponseEntity<Page<RentalCompanyDetails>> listarTodasPorCidade(@PathVariable String cidade, @PageableDefault(size = 10, sort = {"username"}) Pageable pageable) {
    // Não é necessário tratar cidade nula pois, nesse caso, não será mapeado para esse método.
    Page<RentalCompanyDetails> locadoras = service.findAllByCity(cidade, pageable).map(RentalCompanyDetails::new);

    return ResponseEntity.ok().body(locadoras);
  }
}
