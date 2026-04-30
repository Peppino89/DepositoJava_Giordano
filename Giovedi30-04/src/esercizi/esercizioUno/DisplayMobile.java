package esercizi.esercizioUno;

// Implementazione concreta del Display (Observer)
// Rappresenta un display su Mobile
public class DisplayMobile implements Display {

    // Metodo chiamato quando la temperatura cambia
    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Display Mobile aggiornata: "+temperatura);
    }
}
