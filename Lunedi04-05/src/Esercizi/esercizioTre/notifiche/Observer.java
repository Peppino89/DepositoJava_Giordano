package Esercizi.esercizioTre.notifiche;

/**
 * Interfaccia Observer.
 *
 * Chi implementa questa interfaccia può ricevere aggiornamenti/notifiche
 * dal NotificationManager.
 */
public interface Observer {


    void update(String messaggio);
}
