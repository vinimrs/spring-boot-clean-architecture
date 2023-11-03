package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosAtualizacaoLocadora;

// @Service
public class UpdateLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;

    public UpdateLocadoraUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public Locadora execute(Long id, IDadosAtualizacaoLocadora dados) throws LocadoraNotFoundException {
        Locadora cliente = this.locadoraGateway.findById(id)
                .orElseThrow(LocadoraNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            cliente.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            cliente.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            cliente.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            cliente.setEmail(dados.email());

        if(dados.cnpj() != null && !dados.cnpj().isBlank())
            cliente.setCnpj(dados.cnpj());

        if(dados.city() != null && !dados.city().isBlank())
            cliente.setCity(dados.city());

        return this.locadoraGateway.update(cliente);
    }

}
