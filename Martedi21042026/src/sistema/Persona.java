package sistema;

public class Persona {
    String nome;
    String cognome;
    String citta;

    public Persona(){}

    public Persona(String nome, String cognome ) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = "Non inserita ";
    }

    public Persona(String nome, String cognome, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
    }

    public void mostraDettagli(){
        System.out.println("Nome di persona: " + this.nome+" "+this.cognome+" "+this.citta);
    }
}
