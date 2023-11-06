package br.ufscar.dc.dsw.bikerental.usecase.costumer;

import br.ufscar.dc.dsw.bikerental.entity.costumer.exception.CostumerNotFoundException;
import br.ufscar.dc.dsw.bikerental.entity.costumer.gateway.CostumerGateway;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Costumer;
import br.ufscar.dc.dsw.bikerental.entity.costumer.model.Sex;
import br.ufscar.dc.dsw.bikerental.usecase.costumer.dto.IDadosAtualizacaoCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class UpdateClienteUseCase {
    private final CostumerGateway costumerGateway;

    public UpdateClienteUseCase(CostumerGateway costumerGateway) {
        this.costumerGateway = costumerGateway;
    }

    public Costumer execute(Long id, IDadosAtualizacaoCliente dados) throws CostumerNotFoundException {
        Costumer costumer = this.costumerGateway.findById(id)
                .orElseThrow(CostumerNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            costumer.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            costumer.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            costumer.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            costumer.setEmail(dados.email());

        if(dados.cpf() != null && !dados.cpf().isBlank())
            costumer.setCpf(dados.cpf());

        if(dados.phoneNumber() != null && !dados.phoneNumber().isBlank())
            costumer.setPhoneNumber(dados.phoneNumber());

        if(dados.sex() != null && !dados.sex().isBlank())
            costumer.setSex(Sex.valueOf(dados.sex()));

        if(dados.birthdate() != null && !dados.birthdate().isBlank())
            costumer.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

//        if (dados.email() != null && !dados.email().equals(cliente.getEmail())) {
//            int quantidadeEmail = clienteGateway.findAllByEmail(dados.email()).size();
//            if (quantidadeEmail > 0) {
//                throw new ConstraintViolationException(
//
//                );
//            }
//        }
//
//        if (dados.username() != null && !dados.username().equals(cliente.getUsername())) {
//            int quantidadeUsername = clienteGateway.findAllByUsername(dados.username()).size();
//            if (quantidadeUsername > 0) {
//                throw new ConstraintViolationException(
//                    Collections.singleton(validator.validateProperty(cliente, "username").iterator().next())
//                );
//            }
//        }
//
//        if (dados.cpf() != null && !dados.cpf().equals(cliente.getCpf())) {
//            int quantidadeCpf = clienteGateway.findAllByCpf(dados.cpf()).size();
//            if (quantidadeCpf > 0) {
//                throw new ConstraintViolationException(
//                    Collections.singleton(validator.validateProperty(cliente, "cpf").iterator().next())
//                );
//            }
//        }

        return this.costumerGateway.update(costumer);
    }

}
