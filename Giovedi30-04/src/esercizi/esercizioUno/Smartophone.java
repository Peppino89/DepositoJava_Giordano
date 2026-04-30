package esercizi.esercizioUno;

// Implementazione concreta del Display (Observer)
// Rappresenta uno smartphone/auto display
public class Smartophone implements Display {

    // Metodo chiamato quando la temperatura cambia
    @Override
    public void aggiorna(float temperatura) {
        // Stampa la temperatura aggiornata sul dispositivo
        System.out.println("Display Auto aggiornata: "+temperatura);
    }
}