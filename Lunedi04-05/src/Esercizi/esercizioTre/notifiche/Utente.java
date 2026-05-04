package Esercizi.esercizioTre.notifiche;



/**
 * Utente della piattaforma.
 *
 * Ogni utente è un Observer perché può ricevere notifiche.
 * Inoltre ogni utente ha una propria strategia di formattazione della notifica,
 * costruita tramite Decorator Pattern.
 */
public class Utente implements Observer {

    private String nome;
    private Notifica notifica;

    public Utente(String nome, Notifica notifica) {
        this.nome = nome;
        this.notifica = notifica;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void update(String messaggio) {
        // Quando il manager invia una notifica, l'utente la stampa
        // usando la sua personalizzazione.
        System.out.println(nome + " stampa: " + notifica.formatta(messaggio));
    }
}
