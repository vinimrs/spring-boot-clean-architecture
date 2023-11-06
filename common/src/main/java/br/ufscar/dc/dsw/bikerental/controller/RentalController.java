package br.ufscar.dc.dsw.bikerental.controller;

import br.ufscar.dc.dsw.bikerental.domain.Rental;
import br.ufscar.dc.dsw.bikerental.dto.ReturnWIthMessage;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalRegistrationData;
import br.ufscar.dc.dsw.bikerental.dto.rental.RentalDetails;
import br.ufscar.dc.dsw.bikerental.service.spec.IRentalService;
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
@RequestMapping("/rentals")
public class RentalController {

  @Autowired
  private IRentalService service;

  @Autowired
  private ResourceBundle messageBundle;

  private String getMessage(String key, Locale locale) {
    return ResourceBundle.getBundle(messageBundle.getBaseBundleName(), locale).getString(key);
  }

  @GetMapping
  public ResponseEntity<Page<RentalDetails>> listar(@PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<RentalDetails> rentals = service.findAll(pageable).map(RentalDetails::new);

    return ResponseEntity.ok().body(rentals);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ReturnWIthMessage> cadastrar(@RequestBody @Valid RentalRegistrationData dados, UriComponentsBuilder uriBuilder, final Locale locale) {
    Rental rental = service.save(dados);
    URI uri = uriBuilder.path("/rentals/{id}").buildAndExpand(rental.getId()).toUri();

    String message = getMessage("rentals.create.success", locale);

    return ResponseEntity.created(uri).body(new ReturnWIthMessage(message, new RentalDetails(rental)));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<ReturnWIthMessage> deletar(@PathVariable Long id, final Locale locale) {
    Rental rental = service.delete(id);

    String message = getMessage("rentals.delete.success", locale);

    return ResponseEntity.ok().body(new ReturnWIthMessage(message, new RentalDetails(rental)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RentalDetails> detalhar(@PathVariable Long id) {
    Rental rental = service.findById(id);

    return ResponseEntity.ok().body(new RentalDetails(rental));
  }

  @GetMapping("/customers/{id}")
  public ResponseEntity<Page<RentalDetails>> listByCustomers(@PathVariable Long id, @PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<RentalDetails> rentals = service.findAllByCustomer(id, pageable).map(RentalDetails::new);

    return ResponseEntity.ok().body(rentals);
  }

  @GetMapping("/locadoras/{id}")
  public ResponseEntity<Page<RentalDetails>> listarPorLocadora(@PathVariable Long id, @PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
    Page<RentalDetails> rentals = service.findAllByLocadora(id, pageable).map(RentalDetails::new);

    return ResponseEntity.ok().body(rentals);
  }
}
