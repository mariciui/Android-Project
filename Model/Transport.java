package com.example.bookgo.Model;

import java.sql.Date;

public class Transport {
    private int idTransport;
    private int idFurnizor;
    private String locatieStart;
    private String locatieStop;
    private int  pret;
    private String dataStart;
    private String dataStop;

    public void setIdFurnizor(int idFurnizor) {
        this.idFurnizor = idFurnizor;
    }

    public void setLocatieStart(String locatieStart) {
        this.locatieStart = locatieStart;
    }

    public void setLocatieStop(String locatieStop) {
        this.locatieStop = locatieStop;
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

    public void setTipTransport(String tipTransport) {
        this.tipTransport = tipTransport;
    }

    private  String tipTransport;

    public Transport(int idFurnizor, String locatieStart, String locatieStop, int pret, String dataStart, String dataStop, String tipTransport) {
        this.idFurnizor = idFurnizor;
        this.locatieStart = locatieStart;
        this.locatieStop = locatieStop;
        this.pret = pret;
        this.dataStart = dataStart;
        this.dataStop = dataStop;
        this.tipTransport = tipTransport;
    }

    public Transport(){

    }

    public int getIdTransport() {
        return idTransport;
    }

    public int getIdFurnizor() {
        return idFurnizor;
    }

    public String getLocatieStart() {
        return locatieStart;
    }

    public String getLocatieStop() {
        return locatieStop;
    }

    public int getPret() {
        return pret;
    }

    public String  getDataStart() {
        return dataStart;
    }

    public String getDataStop() {
        return dataStop;
    }

    public String getTipTransport() {
        return tipTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }
}
