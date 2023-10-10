package br.ufscar.dc.dsw.locadora.entity.locacao.exception;

public class LocacaoNotFoundException extends Exception {

    public LocacaoNotFoundException() {
        super("A locação não foi encontrado!");
    }
}
