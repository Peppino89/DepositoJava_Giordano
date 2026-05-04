package Esercizi.esercizioTre.notifiche;

/**
 * Decorator concreto che aggiunge un prefisso al messaggio.
 * Esempio: "Notifica: Sistema in manutenzione".
 */
public class PrefissoDecorator extends NotificaDecorator {

    private String prefisso;

    public PrefissoDecorator(Notifica notifica, String prefisso) {
        super(notifica);
        this.prefisso = prefisso;
    }

    @Override
    public String formatta(String messaggio) {
        return prefisso + ": " + notifica.formatta(messaggio);
    }
}
