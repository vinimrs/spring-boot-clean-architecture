package br.ufscar.dc.dsw.bikerental.entity.costumer.exception;

public class CostumerNotFoundException extends Exception {

    public CostumerNotFoundException() {
        super("O cliente não foi encontrado!");
    }
}
