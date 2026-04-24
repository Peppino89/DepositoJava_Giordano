package esercizioGestioneAutostradale;

/*
 * EREDITARIETÀ:
 * Auto ESTENDE Veicolo → eredita attributi e metodi
 */
public class Auto extends Veicolo {

    // Attributo specifico
    private int cilindrata;

    public Auto(String targa,double velocita,int numeroAssi,int cilindrata) {
        super(targa,velocita,numeroAssi); // richiamo costruttore padre
        this.cilindrata=cilindrata;
    }

    /*
     * POLIMORFISMO:
     * Ogni veicolo calcola il pedaggio in modo diverso
     */
    @Override
    public double calcolaPedaggio(){
        return 5*(cilindrata/1000.0);
    }

    @Override
    public void stampaInfo(){
        super.stampaInfo(); // riuso metodo padre
        System.out.println("Cilindrata: "+cilindrata);
    }
}