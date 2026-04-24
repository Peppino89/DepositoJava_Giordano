package esercizioGestioneAutostradale;

/*
 * Classe ASTRATTA:
 * - Non può essere istanziata direttamente
 * - Serve come "modello base" per tutti i veicoli
 * - Definisce attributi e comportamenti comuni
 */
abstract class Veicolo {

    // INCAPSULAMENTO → attributi privati
    private String targa;
    private double velocita;
    private int numeroAssi;

    // Costruttore comune
    public Veicolo(String targa, double velocita, int numeroAssi) {
        this.targa = targa;
        setVelocita(velocita); // uso setter → controllo valori
        setNumeroAssi(numeroAssi);
    }

    // Getter e Setter → controllo accesso ai dati
    public String getTarga() { return targa; }

    public void setTarga(String targa) { this.targa = targa; }

    public double getVelocita() { return velocita; }

    public void setVelocita(double velocita) {
        if(velocita < 0){
            System.out.println("Errore: velocità negativa");
            this.velocita = 0;
        } else {
            this.velocita = velocita;
        }
    }

    public int getNumeroAssi() { return numeroAssi; }

    public void setNumeroAssi(int numeroAssi) {
        if(numeroAssi < 0){
            System.out.println("Errore: assi non validi");
            this.numeroAssi = 0;
        } else {
            this.numeroAssi = numeroAssi;
        }
    }

    /*
     * METODO ASTRATTO:
     * - Non ha implementazione
     * - Obbliga le sottoclassi a definirlo
     */
    public abstract double calcolaPedaggio();

    // Metodo concreto condiviso
    public void stampaInfo(){
        System.out.println("Targa: "+this.targa);
        System.out.println("Velocita: "+this.velocita);
        System.out.println("Numero Assi: "+this.numeroAssi);
    }
}