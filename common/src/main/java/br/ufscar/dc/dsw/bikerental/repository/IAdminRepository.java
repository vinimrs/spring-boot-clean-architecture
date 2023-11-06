package br.ufscar.dc.dsw.bikerental.repository;

import br.ufscar.dc.dsw.bikerental.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
