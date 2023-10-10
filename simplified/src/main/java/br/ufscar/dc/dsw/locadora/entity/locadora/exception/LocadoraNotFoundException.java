package br.ufscar.dc.dsw.locadora.entity.locadora.exception;

public class LocadoraNotFoundException extends Exception {

    public LocadoraNotFoundException() {
        super("A locadora não foi encontrado!");
    }
}
