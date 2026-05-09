package model;

import java.util.ArrayList;

public class TicketNotifier {
    private ArrayList<Observer> observers;

    public TicketNotifier() {
      this.observers = new ArrayList<>();
    }

    public void aggiungiObserver(Observer o) {

        this.observers.add(o);

    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void notifica(String messaggio) {

        for (Observer o : this.observers) {
            o.update(messaggio);
        }
    }
}
