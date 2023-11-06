package br.ufscar.dc.dsw.bikerental.service.spec;

import br.ufscar.dc.dsw.bikerental.domain.Admin;
import br.ufscar.dc.dsw.bikerental.dto.admin.AdminUpdateData;
import br.ufscar.dc.dsw.bikerental.dto.admin.AdminRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService {

  Admin findById(Long id);

  Page<Admin> findAll(Pageable pageable);

  Admin save(AdminRegistrationData admin);

  Admin delete(Long id);

  Admin update(Long id, AdminUpdateData dados);
}
