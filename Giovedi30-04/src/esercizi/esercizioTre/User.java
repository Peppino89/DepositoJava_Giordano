package esercizi.esercizioTre;

// Concrete Observer
// Rappresenta un utente che riceve notifiche
public class User implements Observer {

    private String username;
    private String password;

    // Costruttore
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter username
    public String getUsername() {
        return username;
    }

    // Metodo per verificare la password
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Metodo chiamato quando arriva una notifica
    @Override
    public void update(String messagge) {
        System.out.println(username + " ha ricevuto un avviso: " + messagge);
    }
}