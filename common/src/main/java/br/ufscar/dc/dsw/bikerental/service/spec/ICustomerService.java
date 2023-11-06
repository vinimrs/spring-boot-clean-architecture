package br.ufscar.dc.dsw.bikerental.service.spec;

import br.ufscar.dc.dsw.bikerental.domain.Customer;
import br.ufscar.dc.dsw.bikerental.dto.customer.CUstomerUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.customer.CustomerRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

  Customer findById(Long id);

  Page<Customer> findAll(Pageable pageable);

  Customer save(CustomerRegistrationData customer);

  Customer delete(Long id);

  Customer update(Long id, CUstomerUpdateData dados);
}
