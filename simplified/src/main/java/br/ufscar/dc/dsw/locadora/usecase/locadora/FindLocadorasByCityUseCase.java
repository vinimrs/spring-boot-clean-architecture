package br.ufscar.dc.dsw.locadora.usecase.locadora;

import br.ufscar.dc.dsw.locadora.entity.locadora.exception.LocadoraNotFoundException;
import br.ufscar.dc.dsw.locadora.entity.locadora.gateway.LocadoraGateway;
import br.ufscar.dc.dsw.locadora.entity.locadora.model.Locadora;
import br.ufscar.dc.dsw.locadora.usecase.locadora.dto.IDadosAtualizacaoLocadora;

import java.util.List;

// @Service
public class FindLocadorasByCityUseCase {
    private final LocadoraGateway locadoraGateway;

    public FindLocadorasByCityUseCase(LocadoraGateway locadoraGateway) {
        this.locadoraGateway = locadoraGateway;
    }

    public List<Locadora> execute(String city) {

        return this.locadoraGateway.findAllByCity(city);
    }

}
