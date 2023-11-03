package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.cliente.model.Sexo;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosCadastroLocadora;

// @Service
public class CreateLocadoraUseCase {
    private final LocadoraGateway locadoraGateway;

    public CreateLocadoraUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public Locadora execute(IDadosCadastroLocadora dados) {

        Locadora locadora = new Locadora(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cnpj(), dados.city());

        return this.locadoraGateway.create(locadora);
    }


}
