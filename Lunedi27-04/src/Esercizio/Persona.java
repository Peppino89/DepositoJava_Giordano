package Esercizio;

// Classe astratta base che rappresenta una persona generica
public abstract class Persona {
    // Attributi privati → incapsulamento
    private String nome;
    private int eta;

    // Costruttore per inizializzare i dati della persona
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Getter e setter per accedere/modificare i dati
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    // Metodo astratto → obbliga le sottoclassi a implementarlo
    public abstract void descriviRuolo();
}