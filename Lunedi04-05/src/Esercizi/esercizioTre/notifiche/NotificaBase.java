package Esercizi.esercizioTre.notifiche;

/**
 * Classe concreta di base del Decorator Pattern.
 *
 * Questa classe rappresenta la notifica "semplice", cioè senza
 * personalizzazioni. È il punto di partenza su cui poi vengono applicati
 * i decorator come timestamp, maiuscolo, prefisso, emoji, ecc.
 */
public class NotificaBase implements Notifica {

    @Override
    public String formatta(String messaggio) {
        // Non modifica il messaggio: lo restituisce così com'è.
        return messaggio;
    }
}
