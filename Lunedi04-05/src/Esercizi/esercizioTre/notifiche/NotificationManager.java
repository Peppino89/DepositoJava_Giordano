package Esercizi.esercizioTre.notifiche;

import java.util.ArrayList;
import java.util.List;


/**
 * NotificationManager.
 *
 * Questa classe applica due pattern:
 *
 * 1) Singleton:
 *    Esiste una sola istanza del manager in tutta l'applicazione.
 *    Questo perché il manager rappresenta la sorgente centrale delle notifiche.
 *
 * 2) Observer:
 *    Mantiene una lista di Observer registrati e invia loro le notifiche.
 */
public class NotificationManager {

    // Istanza unica creata subito. Versione semplice e sicura per questo esercizio.
    private static final NotificationManager instance = new NotificationManager();

    // Lista degli utenti/observer registrati.
    private List<Observer> observers = new ArrayList<>();

    /**
     * Costruttore privato.
     *
     * Impedisce di creare oggetti con new NotificationManager().
     */
    private NotificationManager() {}


    public static NotificationManager getInstance() {
        return instance;
    }

    /**
     * Registra un nuovo observer alla piattaforma.
     */
    public void registra(Observer observer) {
        observers.add(observer);
    }

    /**
     * Rimuove un observer dalla piattaforma.
     */
    public void rimuovi(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Invia una notifica a tutti gli observer registrati.
     */
    public void inviaNotifica(String messaggio) {
        System.out.println("\nNotificationManager invia: " + messaggio);

        if (observers.isEmpty()) {
            System.out.println("Nessun utente registrato.");
            return;
        }

        for (Observer observer : observers) {
            observer.update(messaggio);
        }
    }


    public void mostraUtentiRegistrati() {
        if (observers.isEmpty()) {
            System.out.println("Nessun utente registrato.");
            return;
        }

        System.out.println("Utenti registrati:");

        for (int i = 0; i < observers.size(); i++) {
            // In questo esercizio sappiamo che gli observer sono oggetti Utente.
            Utente utente = (Utente) observers.get(i);
            System.out.println((i + 1) + ". " + utente.getNome());
        }
    }


    public boolean rimuoviUtentePerIndice(int indice) {
        if (indice < 0 || indice >= observers.size()) {
            return false;
        }

        observers.remove(indice);
        return true;
    }
}
