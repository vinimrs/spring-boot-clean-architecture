package br.ufscar.dc.dsw.locadora.service.spec;

import br.ufscar.dc.dsw.locadora.domain.Admin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosAtualizacaoAdmin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosCadastroAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService {

  Admin findById(Long id);

  Page<Admin> findAll(Pageable pageable);

  Admin save(DadosCadastroAdmin admin);

  Admin delete(Long id);

  Admin update(Long id, DadosAtualizacaoAdmin dados);
}
