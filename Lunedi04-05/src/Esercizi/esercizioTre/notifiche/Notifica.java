package Esercizi.esercizioTre.notifiche;

/**
 * Interfaccia base del Decorator Pattern.
 *
 * Rappresenta una notifica generica che può formattare un messaggio.
 * Tutte le notifiche concrete e tutti i decorator devono implementare
 * questo metodo.
 */
public interface Notifica {


    String formatta(String messaggio);
}
