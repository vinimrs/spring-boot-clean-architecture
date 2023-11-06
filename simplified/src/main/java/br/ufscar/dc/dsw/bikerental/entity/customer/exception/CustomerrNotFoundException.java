package br.ufscar.dc.dsw.bikerental.entity.customer.exception;

public class CustomerrNotFoundException extends Exception {

    public CustomerrNotFoundException() {
        super("Customer not found!!");
    }
}
