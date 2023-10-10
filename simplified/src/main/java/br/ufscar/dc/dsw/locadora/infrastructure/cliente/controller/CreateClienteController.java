package br.ufscar.dc.dsw.locadora.infrastructure.cliente.controller;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.usecase.cliente.CreateClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CreateClienteController {

    private final CreateClienteUseCase createClienteUseCase;

    public CreateClienteController(CreateClienteUseCase createClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase;
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCliente(@RequestBody Request request) {
        createClienteUseCase.execute(new CreateClienteUseCase.Input(
                request.username(), request.password(), request.name(),
                request.email(), request.cpf(), request.phoneNumber(), request.sex(),
                request.birthdate()
        ));
    }

    public record Request(
            String username,
            String password,
            String name,
            String email,
            String cpf,
            String phoneNumber,
            Sexo sex,
            LocalDate birthdate
    ) {}
}
