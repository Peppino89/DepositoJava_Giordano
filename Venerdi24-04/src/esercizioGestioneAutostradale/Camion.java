package esercizioGestioneAutostradale;

/*
 * Classe concreta che estende Veicolo
 */
public class Camion extends Veicolo{

    private double peso;

    public Camion(String targa, double velocita,int numeroAssi,double peso){
        super(targa,velocita,numeroAssi);
        this.peso=peso;
    }

    /*
     * POLIMORFISMO:
     * Logica diversa rispetto ad Auto
     */
    @Override
    public double calcolaPedaggio() {
        return 10+(super.getNumeroAssi() * 2) + (peso * 0.5);
    }

    @Override
    public void stampaInfo(){
        super.stampaInfo();
        System.out.println("Peso: "+peso);
    }
}
