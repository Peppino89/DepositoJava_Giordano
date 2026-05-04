package Esercizi.esercizioTre.notifiche;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Decorator concreto che aggiunge data e ora al messaggio.
 */
public class TimestampDecorator extends NotificaDecorator {

    public TimestampDecorator(Notifica notifica) {
        super(notifica);
    }

    @Override
    public String formatta(String messaggio) {
        String data = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Prima aggiunge il timestamp, poi richiama la notifica interna.
        return "[" + data + "] " + notifica.formatta(messaggio);
    }
}
