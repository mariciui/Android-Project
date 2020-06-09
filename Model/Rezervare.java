package com.example.bookgo.Model;


import java.sql.Date;

public class Rezervare {
    private int idRezervare;
    private Cazare cazare;
    private Transport transport;
    private Client client;
    private Oferte oferte;
    private String dataCheckIn;
    private String dataCheckOut;

    public Rezervare(Cazare cazare, Transport transport, Client client, Oferte oferte, String dataCheckIn, String dataCheckOut) {
        this.cazare = cazare;
        this.transport = transport;
        this.client = client;
        this.oferte = oferte;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public int getIdRezervare() {
        return idRezervare;
    }

    public Cazare getCazare() {
        return cazare;
    }

    public Transport getTransport() {
        return transport;
    }

    public Client getClient() {
        return client;
    }

    public Oferte getOferte() {
        return oferte;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setIdRezervare(int idRezervare) {
        this.idRezervare = idRezervare;
    }
}
