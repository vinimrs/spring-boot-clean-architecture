package br.ufscar.dc.dsw.bikerental.controller;

import br.ufscar.dc.dsw.bikerental.dto.rentalCompany.RentalCompanyPublicListingData;
import br.ufscar.dc.dsw.bikerental.service.spec.IRentalCompanyService;
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
  private IRentalCompanyService service;

  @GetMapping
  public ResponseEntity<Page<RentalCompanyPublicListingData>> listar(@RequestParam(required = false) String city,
                                                                     @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
    Page<RentalCompanyPublicListingData> locadoras;
    if (city != null && !city.isEmpty()) {
      locadoras = service.findAllByCity(city, pageable).map(RentalCompanyPublicListingData::new);
    } else {
      locadoras = service.findAll(pageable).map(RentalCompanyPublicListingData::new);
    }

    return ResponseEntity.ok().body(locadoras);
  }


}
