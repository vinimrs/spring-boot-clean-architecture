package br.ufscar.dc.dsw.bikerental.infrastructure.config.web;

import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.customer.gateway.CustomerGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.gateway.AdminDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.customer.gateway.CustomerDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.AdminRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.CustomerRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.RentalCompanyRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.rental.gateway.RentalDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.rentalCompany.gateway.RentalCompanyDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.usecase.admin.*;
import br.ufscar.dc.dsw.bikerental.usecase.customer.*;
import br.ufscar.dc.dsw.bikerental.usecase.rental.*;
import br.ufscar.dc.dsw.bikerental.usecase.rentalCompany.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.ResourceBundle;

@Configuration
public class MvcConfig {

  @Bean
  public ResourceBundle messageBundle() {
    return ResourceBundle.getBundle("ValidationMessages");
  }

  @Bean
  public LocaleResolver sessionLocaleResolver() {
    return new AcceptHeaderResolver();
  }

  @Bean
  public CreateCustomerUseCase createCustomerUseCase(CustomerRepository customerRepository) {
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
    return new CreateCustomerUseCase(customerGateway);
  }

  @Bean
  public GetCustomerUseCase getCustomerUseCase(CustomerRepository customerRepository) {
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
    return new GetCustomerUseCase(customerGateway);
  }

  @Bean
  public SearchCustomerUseCase searchCustomerUseCase(CustomerRepository customerRepository) {
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
    return new SearchCustomerUseCase(customerGateway);
  }

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository customerRepository) {
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
    return new UpdateCustomerUseCase(customerGateway);
  }

  @Bean
  public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository customerRepository) {
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
    return new DeleteCustomerUseCase(customerGateway);
  }

  @Bean
  public CreateRentalCompanyUseCase createRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new CreateRentalCompanyUseCase(rentalCompanyGateway);
  }

  @Bean
  public GetRentalCompanyUseCase getRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new GetRentalCompanyUseCase(rentalCompanyGateway);
  }

  @Bean
  public SearchRentalCompanyUseCase searchRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new SearchRentalCompanyUseCase(rentalCompanyGateway);
  }

  @Bean
  public UpdateRentalCompanyUseCase updateRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new UpdateRentalCompanyUseCase(rentalCompanyGateway);
  }

  @Bean
  public DeleteRentalCompanyUseCase deleteRentalCompanyUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new DeleteRentalCompanyUseCase(rentalCompanyGateway);
  }

  @Bean
  public FindRentalCompaniesByCityUseCase findRentalCompaniesByCityUseCase(RentalCompanyRepository rentalCompanyRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    return new FindRentalCompaniesByCityUseCase(rentalCompanyGateway);
  }

  @Bean
  public CreateAdminUseCase createAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new CreateAdminUseCase(adminGateway);
  }

  @Bean
  public GetAdminUseCase getAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new GetAdminUseCase(adminGateway);
  }

  @Bean
  public SearchAdminUseCase searchAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new SearchAdminUseCase(adminGateway);
  }

  @Bean
  public UpdateAdminUseCase updateAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new UpdateAdminUseCase(adminGateway);
  }

  @Bean
  public DeleteAdminUseCase deleteAdminUseCase(AdminRepository adminRepository) {
    AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
    return new DeleteAdminUseCase(adminGateway);
  }

  @Bean
  public DeleteRentalUseCase deleteRentalUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new DeleteRentalUseCase(rentalGateway);
  }

  @Bean
  public CreateRentalUseCase createRentalUseCase(RentalRepository rentalRepository, RentalCompanyRepository rentalCompanyRepository, CustomerRepository customerRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);

    return new CreateRentalUseCase(rentalGateway, rentalCompanyGateway, customerGateway);
  }

  @Bean
  public GetRentalUseCase getRentalUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new GetRentalUseCase(rentalGateway);
  }

  @Bean
  public ListRentalsByRentalCompanyUseCase listRentalsByRentalCompanyUseCase(RentalRepository rentalRepository, RentalCompanyRepository rentalCompanyRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(rentalCompanyRepository);

    return new ListRentalsByRentalCompanyUseCase(rentalGateway, rentalCompanyGateway);
  }

  @Bean
  public ListRentalsByCustomerUseCase listRentalsByCustomerUseCase(RentalRepository rentalRepository, CustomerRepository customerRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);

    return new ListRentalsByCustomerUseCase(rentalGateway, customerGateway);
  }

  @Bean
  public SearchRentalsUseCase searchRentalsUseCase(RentalRepository rentalRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(rentalRepository);
    return new SearchRentalsUseCase(rentalGateway);
  }
}
