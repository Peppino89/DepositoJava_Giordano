package esempiPattern.databaseSingleton;

import java.util.ArrayList;

public class DatabaseManager {

    // Istanza unica del Singleton
    private static DatabaseManager instance;

    // Contatore delle connessioni effettuate
    private long connectionCount;

    //"Database" simulato: lista di utenti
    private ArrayList<Utente> utenti;

    //Costruttore PRIVATO → impedisce new dall’esterno
    private DatabaseManager() {
        utenti = new ArrayList<>(); // inizializzo il "DB"
    }

    // 🔹 Metodo statico per ottenere sempre la stessa istanza
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager(); // creata una sola volta
        }
        return instance;
    }

    // Simulo apertura connessione al database
    public void connect() {
        connectionCount++; // incremento contatore
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
    }

    //Simulo Salvataggio dato nel "DB"
    public void salvaUtente(Utente u) {

        utenti.add(u);
    }

    //Simulo Lettura dati dal "DB"
    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    // Ritorno il numero totale di connessioni effettuate
    public long getConnectionCount() {
        return connectionCount;
    }
}