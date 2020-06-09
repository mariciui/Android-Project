package com.example.bookgo.Model;


import java.sql.Date;

public class Client {
    private int idClient;
    private String userLog;
    private String parola;
    private String nume;
    private String prenume;
    private String rang;
    private int puncte;
    private String dataNasterii;

    public Client(){

    }

    public Client(String userLog, String parola, String nume, String prenume, String rang, int puncte, String dataNasterii){
        this.userLog=userLog;
        this.parola=parola;
        this.nume=nume;
        this.prenume=prenume;
        this.rang=rang;
        this.puncte=puncte;
        this.dataNasterii=dataNasterii;
    }

    public String getParola() {
        return parola;
    }

    public String getUserLog() {
        return userLog;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setUserLog(String userLog) {
        this.userLog = userLog;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getRang() {
        return rang;
    }

    public int getPuncte() {
        return puncte;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
