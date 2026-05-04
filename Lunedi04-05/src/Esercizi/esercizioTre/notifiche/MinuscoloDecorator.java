package Esercizi.esercizioTre.notifiche;

/**
 * Decorator concreto che converte il messaggio in minuscolo.
 */
public class MinuscoloDecorator extends NotificaDecorator {

    public MinuscoloDecorator(Notifica notifica) {
        super(notifica);
    }

    @Override
    public String formatta(String messaggio) {
        return notifica.formatta(messaggio).toLowerCase();
    }
}
