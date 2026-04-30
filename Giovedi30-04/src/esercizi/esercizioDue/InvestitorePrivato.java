package esercizi.esercizioDue;

// Observer concreto
// Rappresenta un investitore privato
public class InvestitorePrivato implements Investitore {

    private String nome;

    // Costruttore
    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    // Metodo chiamato quando arriva una notifica
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Investitore privato " + nome +
                ": ho ricevuto aggiornamento su " + azione +
                ", nuovo valore: " + valore + "€");
    }
}