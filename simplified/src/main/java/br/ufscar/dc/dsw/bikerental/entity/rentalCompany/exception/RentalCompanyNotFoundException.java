package br.ufscar.dc.dsw.bikerental.entity.rentalCompany.exception;

public class RentalCompanyNotFoundException extends Exception {

    public RentalCompanyNotFoundException() {
        super("A locadora não foi encontrado!");
    }
}
