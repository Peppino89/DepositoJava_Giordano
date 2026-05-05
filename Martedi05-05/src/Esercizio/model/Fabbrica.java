package Esercizio.model;

import java.util.ArrayList;

//Contiene sia il Singleton + Subject (Observer)
public class Fabbrica {

    private static Fabbrica instance;

    private ArrayList<Veicolo>veicoli;
    private ArrayList<Observer>observers;

    public Fabbrica() {
        this.veicoli = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static Fabbrica getInstance() {
        if (instance == null) {
            instance = new Fabbrica();
        }

        return instance;
    }


    //Registrazione Observer
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    //Notifica Observer
    private void notifyObservers(String message) {
        for (Observer observer : this.observers) {
            observer.update(message);
        }
    }

    //Produzione del veicolo
    public void produciVeicolo(Veicolo veicolo) {
        this.veicoli.add(veicolo);
        notifyObservers("Nuovo Veicolo prodotto: "+veicolo.getDescription());
    }

    public ArrayList<Veicolo> getVeicoli() {
        return veicoli;
    }


}
