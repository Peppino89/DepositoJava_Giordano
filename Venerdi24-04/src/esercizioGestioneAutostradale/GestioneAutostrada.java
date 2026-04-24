package esercizioGestioneAutostradale;

import java.util.ArrayList;

public class GestioneAutostrada {
    public static void main(String[] args) {
        ArrayList<Veicolo> veicoli = new ArrayList<>();

        veicoli.add(new Auto("AB123CD", 120, 2, 1600));
        veicoli.add(new Camion("EF456GH", 90, 4, 12.5));
        veicoli.add(new Moto("IJ789KL", 100, 2, true));

        for (Veicolo veicolo : veicoli) {
            System.out.println("----------------------");

            veicolo.stampaInfo();

            double pedaggio = veicolo.calcolaPedaggio();

            System.out.println("Pedaggio: " + pedaggio + " euro");
        }
    }
}
