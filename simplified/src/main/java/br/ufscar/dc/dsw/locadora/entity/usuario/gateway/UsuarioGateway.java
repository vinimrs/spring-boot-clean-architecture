package br.ufscar.dc.dsw.locadora.entity.usuario.gateway;

import br.ufscar.dc.dsw.locadora.entity.usuario.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {
    void create(Usuario usuario);
    void update(Usuario usuario);
    void delete(Long id);

    Optional<Usuario> findById(Long id);
    List<Usuario> searchByName(String nameFragment);
}
