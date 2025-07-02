package com.example.cajeroautomatico.Modelo;

public class Clientes {
private String NumeroCuenta;
private double Saldo;
private String pin;


    public Clientes(String numeroCuenta, double saldo, String pin) {
        NumeroCuenta = numeroCuenta;
        Saldo = saldo;
        this.pin = pin;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

