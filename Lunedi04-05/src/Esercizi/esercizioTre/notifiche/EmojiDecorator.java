package Esercizi.esercizioTre.notifiche;

/**
 * Decorator concreto che aggiunge una emoji alla fine del messaggio.
 */
public class EmojiDecorator extends NotificaDecorator {

    private String emoji;

    public EmojiDecorator(Notifica notifica, String emoji) {
        super(notifica);
        this.emoji = emoji;
    }

    @Override
    public String formatta(String messaggio) {
        return notifica.formatta(messaggio) + " " + emoji;
    }
}
