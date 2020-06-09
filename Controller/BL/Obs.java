
/**
 * clasa responsabila cu implementarea Observerului
 */


package com.example.bookgo.Controller.BL;

import com.example.bookgo.Model.Furnizor;

import java.util.Observable;
import java.util.Observer;

public class Obs extends Observable {
    public Observer observer;


    public void notify(Observable o, Furnizor f) {

        observer.update(this, f);
    }

    public void registerObserver(Observer obs) {

        this.observer = obs;
    }


    public Observable getObs(){
        return this;
    }


}
