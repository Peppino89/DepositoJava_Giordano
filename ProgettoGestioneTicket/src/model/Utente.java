package model;

public class Utente {
    private String nomeUtente;
    private String password;
    private String ruolo;

    public Utente(String nomeUtente, String password, String ruolo) {
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }

}
