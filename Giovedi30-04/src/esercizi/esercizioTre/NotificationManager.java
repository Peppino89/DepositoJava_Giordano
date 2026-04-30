package esercizi.esercizioTre;

import java.util.ArrayList;

// Classe Singleton + Subject
// Gestisce gli observer (utenti) e invia le notifiche
public class NotificationManager {

    // Istanza unica (Singleton)
    private static NotificationManager instance;

    // Lista degli observer iscritti alle notifiche
    private ArrayList<Observer> observers;

    // Metodo per ottenere l'unica istanza
    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    // Metodo per registrare un observer (iscrizione notifiche)
    public void register(Observer observer) {
        // Verifica se l'utente è già iscritto
        if (!observers.contains(observer)) {
            System.out.println("Iscrizione alle notifiche completata.");
        } else {
            System.out.println("Sei già iscritto alle notifiche. ");
        }
    }

    // Metodo per rimuovere un observer (disiscrizione)
    public void unregister(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Cancellazione dalle notifiche completata.");
        } else {
            System.out.println("Non sei iscritto alle notifiche. ");
        }
    }

    // Metodo per pubblicare una nuova notifica
    public void publishNotification(String message) {
        System.out.println("\nNuovo avviso pubblicato: "+message);

        // Controlla se ci sono observer iscritti
        if(observers.isEmpty()) {
            System.out.println("Nessun utente è iscritto alle notifiche.");
        } else {
            notifyObservers(message);
        }
    }

    // Metodo privato che notifica tutti gli observer
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}