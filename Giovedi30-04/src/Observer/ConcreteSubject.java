package Observer;

import java.util.ArrayList;
import java.util.List;

// Classe concreta che implementa il Subject (gestore delle notifiche)
public class ConcreteSubject implements Subject {

    // Lista degli osservatori (utenti iscritti alle notifiche)
    private List<Observer> observers = new ArrayList<Observer>();

    // Stato del subject (messaggio da inviare)
    private String state;


    // Metodo per impostare un nuovo stato (nuovo avviso)
    // Quando cambia lo stato, notifica tutti gli observer
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    // Metodo per registrare un nuovo observer
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Metodo per rimuovere un observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // Metodo che notifica tutti gli observer
    @Override
    public void notifyObservers() {
        // Scorre tutti gli utenti iscritti e invia il messaggio
        for (Observer o : observers) {
            o.update(state);
        }
    }
}