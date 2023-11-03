package br.ufscar.dc.dsw.locadora.infrastructure.config.web;

import br.ufscar.dc.dsw.locadora.entity.admin.gateway.AdminGateway;
import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.infrastructure.admin.gateway.AdminDatabaseGateway;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.gateway.ClienteDatabaseGateway;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.AdminRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.LocadoraRepository;
import br.ufscar.dc.dsw.locadora.infrastructure.locadora.gateway.LocadoraDatabaseGateway;
import br.ufscar.dc.dsw.locadora.usecase.admin.*;
import br.ufscar.dc.dsw.locadora.usecase.cliente.*;
import br.ufscar.dc.dsw.locadora.usecase.locadora.*;
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
    ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository);
    return new CreateClienteUseCase(clienteGateway);
  }

  @Bean
  public GetClienteUseCase getClienteUseCase(ClienteRepository clienteRepository) {
    ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository);
    return new GetClienteUseCase(clienteGateway);
  }

  @Bean
  public SearchClienteUseCase searchClienteUseCase(ClienteRepository clienteRepository) {
    ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository);
    return new SearchClienteUseCase(clienteGateway);
  }

  @Bean
  public UpdateClienteUseCase updateClienteUseCase(ClienteRepository clienteRepository) {
    ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository);
    return new UpdateClienteUseCase(clienteGateway);
  }

  @Bean
  public DeleteClienteUseCase deleteClienteUseCase(ClienteRepository clienteRepository) {
    ClienteGateway clienteGateway = new ClienteDatabaseGateway(clienteRepository);
    return new DeleteClienteUseCase(clienteGateway);
  }

  @Bean
  public CreateLocadoraUseCase createLocadoraUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new CreateLocadoraUseCase(locadoraGateway);
  }

  @Bean
  public GetLocadoraUseCase getLocadoraUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new GetLocadoraUseCase(locadoraGateway);
  }

  @Bean
  public SearchLocadoraUseCase searchLocadoraUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new SearchLocadoraUseCase(locadoraGateway);
  }

  @Bean
  public UpdateLocadoraUseCase updateLocadoraUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new UpdateLocadoraUseCase(locadoraGateway);
  }

  @Bean
  public DeleteLocadoraUseCase deleteLocadoraUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new DeleteLocadoraUseCase(locadoraGateway);
  }

  @Bean
  public FindLocadorasByCityUseCase findLocadorasByCityUseCase(LocadoraRepository locadoraRepository) {
    LocadoraGateway locadoraGateway = new LocadoraDatabaseGateway(locadoraRepository);
    return new FindLocadorasByCityUseCase(locadoraGateway);
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
}
