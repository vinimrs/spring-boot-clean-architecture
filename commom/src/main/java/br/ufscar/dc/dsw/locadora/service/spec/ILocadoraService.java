package br.ufscar.dc.dsw.locadora.service.spec;

import br.ufscar.dc.dsw.locadora.domain.Locadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosCadastroLocadora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocadoraService {

  Locadora findById(Long id);

  Page<Locadora> findAll(Pageable pageable);

  Locadora save(DadosCadastroLocadora locadora);

  Locadora delete(Long id);

  Locadora update(Long id, DadosAtualizacaoLocadora dados);

  Page<Locadora> findAllByCity(String city, Pageable pageable);

  List<String> findAllCities();
}
