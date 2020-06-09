package com.example.bookgo.Model;

import java.util.Observable;
import java.util.Observer;

public class Admin implements Observer {

    String nume;
    String parola;
    public Admin(String nume, String parola) {
        this.nume = nume;
        this.parola = parola;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Exista o noua cerere de furnizor!");
    }
}
