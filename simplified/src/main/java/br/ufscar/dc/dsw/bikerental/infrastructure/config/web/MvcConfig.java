package br.ufscar.dc.dsw.bikerental.infrastructure.config.web;

import br.ufscar.dc.dsw.bikerental.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.rental.gateway.RentalGateway;
import br.ufscar.dc.dsw.bikerental.entity.rentalCompany.gateway.RentalCompanyGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.admin.gateway.AdminDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.cliente.gateway.CostumerDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.AdminRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.LocacaoRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository.LocadoraRepository;
import br.ufscar.dc.dsw.bikerental.infrastructure.locacao.gateway.RentalDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.infrastructure.locadora.gateway.RentalCompanyDatabaseGateway;
import br.ufscar.dc.dsw.bikerental.usecase.admin.*;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.*;
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
  public CreateClienteUseCase createClienteUseCase(ClienteRepository clienteRepository) {
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);
    return new CreateClienteUseCase(costumerGateway);
  }

  @Bean
  public GetClienteUseCase getClienteUseCase(ClienteRepository clienteRepository) {
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);
    return new GetClienteUseCase(costumerGateway);
  }

  @Bean
  public SearchClienteUseCase searchClienteUseCase(ClienteRepository clienteRepository) {
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);
    return new SearchClienteUseCase(costumerGateway);
  }

  @Bean
  public UpdateClienteUseCase updateClienteUseCase(ClienteRepository clienteRepository) {
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);
    return new UpdateClienteUseCase(costumerGateway);
  }

  @Bean
  public DeleteClienteUseCase deleteClienteUseCase(ClienteRepository clienteRepository) {
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);
    return new DeleteClienteUseCase(costumerGateway);
  }

  @Bean
  public CreateLocadoraUseCase createLocadoraUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new CreateLocadoraUseCase(rentalCompanyGateway);
  }

  @Bean
  public GetLocadoraUseCase getLocadoraUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new GetLocadoraUseCase(rentalCompanyGateway);
  }

  @Bean
  public SearchLocadoraUseCase searchLocadoraUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new SearchLocadoraUseCase(rentalCompanyGateway);
  }

  @Bean
  public UpdateLocadoraUseCase updateLocadoraUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new UpdateLocadoraUseCase(rentalCompanyGateway);
  }

  @Bean
  public DeleteLocadoraUseCase deleteLocadoraUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new DeleteLocadoraUseCase(rentalCompanyGateway);
  }

  @Bean
  public FindLocadorasByCityUseCase findLocadorasByCityUseCase(LocadoraRepository locadoraRepository) {
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    return new FindLocadorasByCityUseCase(rentalCompanyGateway);
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
  public DeleteRentalUseCase deleteLocacaoUseCase(LocacaoRepository locacaoRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    return new DeleteRentalUseCase(rentalGateway);
  }

  @Bean
  public CreateRentalUseCase createLocacaoUseCase(LocacaoRepository locacaoRepository, LocadoraRepository locadoraRepository, ClienteRepository clienteRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);

    return new CreateRentalUseCase(rentalGateway, rentalCompanyGateway, costumerGateway);
  }

  @Bean
  public GetRentalUseCase getLocacaoUseCase(LocacaoRepository locacaoRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    return new GetRentalUseCase(rentalGateway);
  }

  @Bean
  public ListRentalsByRentalCompanyUseCase listLocacoesByLocadoraUseCase(LocacaoRepository locacaoRepository, LocadoraRepository locadoraRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    RentalCompanyGateway rentalCompanyGateway = new RentalCompanyDatabaseGateway(locadoraRepository);

    return new ListRentalsByRentalCompanyUseCase(rentalGateway, rentalCompanyGateway);
  }

  @Bean
  public ListRentalsByCostumerUseCase listLocacoesByClienteUseCase(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    CostumerGateway costumerGateway = new CostumerDatabaseGateway(clienteRepository);

    return new ListRentalsByCostumerUseCase(rentalGateway, costumerGateway);
  }

  @Bean
  public SearchRentalsUseCase searchLocacaoUseCase(LocacaoRepository locacaoRepository) {
    RentalGateway rentalGateway = new RentalDatabaseGateway(locacaoRepository);
    return new SearchRentalsUseCase(rentalGateway);
  }
}
