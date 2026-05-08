package model;

public class Admin extends Utente {
    public Admin(String nomeUtente, String password) {
        super(nomeUtente,password,"ADMIN");
    }
}
