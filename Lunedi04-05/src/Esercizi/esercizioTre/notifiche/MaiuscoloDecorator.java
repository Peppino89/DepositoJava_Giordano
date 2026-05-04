package Esercizi.esercizioTre.notifiche;

/**
 * Decorator concreto che converte il messaggio in maiuscolo.
 */
public class MaiuscoloDecorator extends NotificaDecorator {

    public MaiuscoloDecorator(Notifica notifica) {
        super(notifica);
    }

    @Override
    public String formatta(String messaggio) {
        // Prima ottiene il messaggio dalla notifica interna,
        // poi lo converte in maiuscolo.
        return notifica.formatta(messaggio).toUpperCase();
    }
}
