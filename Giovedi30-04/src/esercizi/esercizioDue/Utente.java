package esercizi.esercizioDue;

// Classe che rappresenta un utente della piattaforma
// Implementa Observer (Investitore) e usa il pattern Singleton
public class Utente implements Investitore {

    // Istanza unica (Singleton)
    private static Utente instance;

    private String username;
    private String password;

    // Costruttore privato (tipico del Singleton)
    private Utente(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metodo per registrare l'utente (crea l'unica istanza)
    public static Utente registrati(String username, String password) {
        if (instance == null) {
            instance = new Utente(username, password);
            System.out.println("Registrazione completata!");
        } else {
            System.out.println("Esiste già un utente registrato.");
        }

        return instance;
    }

    // Metodo di login
    public static Utente login(String username, String password) {
        if (instance == null) {
            System.out.println("Nessun utente registrato. Registrati prima.");
            return null;
        }

        // Controllo credenziali
        if (instance.username.equals(username) && instance.password.equals(password)) {
            System.out.println("Login effettuato. Benvenuto " + username + "!");
            return instance;
        } else {
            System.out.println("Username o password errati.");
            return null;
        }
    }

    // Getter username
    public String getUsername() {
        return username;
    }

    // Metodo chiamato quando arriva una notifica
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Utente " + username +
                ": notifica ricevuta -> " + azione +
                " = " + valore + "€");
    }
}