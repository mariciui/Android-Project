package com.example.bookgo.Model;

public class Oferte {
    private int idOferta;
    private int cazare;
    private int transport;
    private int furnizor;

    public Oferte(){

    }

    public Oferte(int cazare, int transport, int furnizor) {
        this.cazare = cazare;
        this.transport = transport;
        this.furnizor = furnizor;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public int getCazare() {
        return cazare;
    }

    public int getTransport() {
        return transport;
    }

    public int getFurnizor() {
        return furnizor;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }
}

