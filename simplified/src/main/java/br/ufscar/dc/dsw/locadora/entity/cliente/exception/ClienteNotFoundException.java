package br.ufscar.dc.dsw.locadora.entity.cliente.exception;

public class ClienteNotFoundException extends Exception {

    public ClienteNotFoundException() {
        super("O cliente não foi encontrado!");
    }
}
