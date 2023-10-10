package br.ufscar.dc.dsw.locadora.entity.usuario.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("O usuário não foi encontrado!");
    }
}
