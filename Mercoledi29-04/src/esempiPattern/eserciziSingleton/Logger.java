package esempiPattern.eserciziSingleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Logger {

    private static Logger logger;

    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }


public void scriviMessaggio(String messaggio) {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(messaggio+" Ora "+ now.format(dtf));
}

@Override
public String toString() {
     return "Questa istanza si trova all'indirizzo di memoria:  "+super.toString();
    }

}
