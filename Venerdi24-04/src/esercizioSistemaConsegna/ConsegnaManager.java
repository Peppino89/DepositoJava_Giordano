package esercizioSistemaConsegna;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsegnaManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();

        veicoli.add(new Furgone("AB123CD",500,20));
        veicoli.add(new Drone("DRONE-01",10,30));

        for (VeicoloConsegna veicolo : veicoli) {
            veicolo.stampaInfo();

            System.out.println("Inserisci una destinazione: ");
            String destinazione = input.nextLine();
            veicolo.consegnaPacco(destinazione);

            if(veicolo instanceof Tracciabile) {
                Tracciabile tracciabile = (Tracciabile) veicolo;
                tracciabile.tracciaConsegna("Track: "+System.currentTimeMillis());

            }
            System.out.println("----------------------------");
        }
        input.close();
    }
}
