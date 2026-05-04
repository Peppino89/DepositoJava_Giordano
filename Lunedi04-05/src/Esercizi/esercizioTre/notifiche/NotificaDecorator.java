package Esercizi.esercizioTre.notifiche;

/**
 * Decorator astratto.
 *
 * Serve come classe base comune per tutti i decorator concreti.
 * Contiene una Notifica interna, cioè l'oggetto che viene "avvolto"
 * e decorato.
 *
 * È abstract perché non ha una personalizzazione specifica propria:
 * le personalizzazioni reali sono nelle sottoclassi concrete.
 */
public abstract class NotificaDecorator implements Notifica {

    // protected così le sottoclassi possono accedere alla notifica decorata.
    protected Notifica notifica;

    public NotificaDecorator(Notifica notifica) {
        this.notifica = notifica;
    }

    @Override
    public String formatta(String messaggio) {
        // Di default delega il lavoro alla notifica interna.
        return notifica.formatta(messaggio);
    }
}
