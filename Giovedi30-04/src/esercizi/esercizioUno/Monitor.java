package esercizi.esercizioUno;



// Implementazione concreta del Display (Observer)
// Rappresenta un monitor
public class Monitor implements Display {

    // Metodo chiamato quando la temperatura cambia
    @Override
    public void aggiorna(float temperatura) {
        // Stampa la temperatura aggiornata sul monitor
        System.out.println("Display Monitor: "+temperatura);
    }
}