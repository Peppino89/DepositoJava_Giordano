package esercizi.esercizioUno;

// Implementazione concreta del Display (Observer)
// Rappresenta un display su console
public class DisplayConsole implements Display {

    // Metodo chiamato quando la temperatura cambia
    @Override
    public void aggiorna(float temperatura) {

        System.out.println("Display Console aggiornata: "+temperatura);
    }
}