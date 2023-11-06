package br.ufscar.dc.dsw.bikerental.entity.user.gateway;

import br.ufscar.dc.dsw.bikerental.entity.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    void create(User user);
    void update(User user);
    void delete(Long id);

    Optional<User> findById(Long id);
    List<User> searchByName(String nameFragment);
}
