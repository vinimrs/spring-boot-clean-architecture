package br.ufscar.dc.dsw.locadora.infrastructure.config.web;

import br.ufscar.dc.dsw.locadora.entity.cliente.gateway.ClienteGateway;
import br.ufscar.dc.dsw.locadora.infrastructure.cliente.gateway.ClienteDatabaseGateway;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository.ClienteRepository;
import br.ufscar.dc.dsw.locadora.usecase.cliente.*;
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
}
