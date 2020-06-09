package com.example.bookgo.Model;

import java.sql.Date;

public class Furnizor {
    private int idFurnizor;
    private String userLog;
    private String parola;
    private String nume;
    private String prenume;
    private String dataNsterii;

    public Furnizor(){

    }
    public void setParola(String parola) {
        this.parola = parola;
    }

    public Furnizor(String userLog, String parola, String nume, String prenume, String dataNsterii) {
        this.userLog = userLog;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNsterii = dataNsterii;
    }

    public int getIdFurnizor() {
        return idFurnizor;
    }

    public String getUserLog() {
        return userLog;
    }

    public String getParola() {
        return parola;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDataNsterii() {
        return dataNsterii;
    }

    public void setIdFurnizor(int idFurnizor) {
        this.idFurnizor = idFurnizor;
    }


}
