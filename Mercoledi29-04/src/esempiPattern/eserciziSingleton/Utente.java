package esempiPattern.eserciziSingleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utente {
    private static Utente utente;

    private Utente() {}

    public static Utente getInstance() {

        if (utente == null) {
            utente = new Utente();
        }

        return utente;
    }

    public void scriviMessaggio(String messaggio) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("L'utente ha scritto: "+messaggio+" in data: "+now.format(formatter));
    }

    @Override
    public String toString() {
        return "Questa istanza di utente si trova all'indirizzo di memoria: "+super.toString();
    }


}
