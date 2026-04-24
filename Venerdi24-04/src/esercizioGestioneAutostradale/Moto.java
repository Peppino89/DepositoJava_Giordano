package esercizioGestioneAutostradale;

/*
 * Anche Moto è una specializzazione di Veicolo
 */
public class Moto extends Veicolo {

    private boolean haBauletto;

    public Moto(String targa, double velocita, int numeroAssi, boolean haBauletto) {
        super(targa, velocita, numeroAssi);
        this.haBauletto = haBauletto;
    }

    /*
     * POLIMORFISMO:
     * comportamento diverso in base allo stato
     */
    @Override
    public double calcolaPedaggio() {
        if (haBauletto) {
            return 3.50;
        }
        return 3.00;
    }

    @Override
    public void stampaInfo() {
        super.stampaInfo();
        System.out.println("Ha bauletto: " + haBauletto);
    }
}
