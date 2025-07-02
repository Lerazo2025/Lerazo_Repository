package com.example.cajeroautomatico.Controlador;
import com.example.cajeroautomatico.Modelo.Clientes;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("Client_bean")
@SessionScoped

public class Controladorbean implements Serializable {
    private List<Clientes>cliente;
    private String cuentacliente;
    private String pincliente;
    private Double efectivocliente;
    private Double saldoliente;


    public Controladorbean() {
        cliente=new ArrayList<>();
        cliente.add(new Clientes("001", 4000, "1234"));
        cliente.add(new Clientes("002", 5000, "0820"));
        cliente.add(new Clientes("003", 6000, "2001"));
        cliente.add(new Clientes("004", 7000, "1518"));
        cliente.add(new Clientes("005", 2000, "3334"));

    }

    public void deposito(){
    Clientes cliente = buscarCliente();
    if(cliente==null){
        mostrarmensaje("Cuenta o Pin Invalido");
        return;
    }
    if(efectivocliente<=0){
        mostrarmensaje("Valor monetario Incorrecto");
        return;

    }
    cliente.setSaldo(cliente.getSaldo()+efectivocliente);
    saldoliente=cliente.getSaldo();
    mostrarmensaje("Deposito Procesado/"+" Nuevo Saldo: L."+saldoliente);

        cuentacliente=null;
        efectivocliente = null;
        pincliente = null;
    }


    public void retiro(){
        Clientes cliente = buscarCliente();
        if(cliente==null){
            mostrarmensaje("Cuenta o Pin Invalido");
            return;
        }
        if(efectivocliente<=0){
            mostrarmensaje("Valor monetario Incorrecto");
            return;

        }
        if(cliente.getSaldo()<efectivocliente){
            mostrarmensaje("Saldo Insuficiente");
            return;

        }

        cliente.setSaldo(cliente.getSaldo()-efectivocliente);
        saldoliente=cliente.getSaldo();
        mostrarmensaje("Retiro Procesado/"+" Nuevo Saldo: L."+saldoliente);

        cuentacliente=null;
        efectivocliente = null;
        pincliente = null;
    }


public Clientes buscarCliente(){
        for (Clientes clint : cliente) {
            if(clint.getNumeroCuenta().equals(cuentacliente)&& clint.getPin().equals(pincliente)){
                return clint;
            }
        }
        return null;
}

private void mostrarmensaje(String mensaje){
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(mensaje));
}

    public String getCuentacliente() {

        return cuentacliente;
    }

    public void setCuentacliente(String cuentacliente) {

        this.cuentacliente = cuentacliente;
    }

    public String getPincliente() {

        return pincliente;
    }

    public void setPincliente(String pincliente) {

        this.pincliente = pincliente;
    }

    public Double getEfectivocliente() {
        return efectivocliente;
    }

    public void setEfectivocliente(Double efectivocliente) {

        this.efectivocliente = efectivocliente;
    }

    public Double getSaldoliente() {
        return saldoliente;
    }

    public void setSaldoliente(Double saldoliente) {

        this.saldoliente = saldoliente;
    }
}


