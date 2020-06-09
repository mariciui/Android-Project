package com.example.bookgo.Model;

import java.sql.Date;

public class Cazare {
    private int idCazare;
    private int idFurnizor;
    private String locatie;
    private  int pret;
    private String dataStart;
    private String dataStop;
    private String tipCazare;

    public Cazare(){

    }

    public void setIdFurnizor(int idFurnizor) {
        this.idFurnizor = idFurnizor;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public void setDataStop(String dataStop) {
        this.dataStop = dataStop;
    }

    public void setTipCazare(String tipCazare) {
        this.tipCazare = tipCazare;
    }

    public Cazare(int idFurnizor, String locatie, int pret, String dataStart, String dataStop, String tipCazare){
        this.idFurnizor=idFurnizor;
        this.locatie=locatie;
        this.pret=pret;
        this.dataStart=dataStart;
        this.dataStop=dataStop;
        this.tipCazare=tipCazare;
    }

    public int getIdCazare() {
        return idCazare;
    }

    public int getIdFurnizor() {
        return idFurnizor;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getPret() {
        return pret;
    }

    public String getDataStart() {
        return dataStart;
    }

    public String getDataStop() {
        return dataStop;
    }

    public String getTipCazare() {
        return tipCazare;
    }

    public void setIdCazare(int idCazare) {
        this.idCazare = idCazare;
    }
}
