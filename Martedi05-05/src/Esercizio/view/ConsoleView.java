package Esercizio.view;

import Esercizio.model.Observer;
import Esercizio.model.Veicolo;

import java.util.ArrayList;


//View solo per la stampa
public class ConsoleView implements Observer {


    @Override
    public void update(String message) {
       System.out.println("C'è una notifica: "+message);
    }

    public void mostraVeicoli(ArrayList<Veicolo> veicoli) {
        System.out.println("\n--- Lista Veicoli ---");
        for (Veicolo veicolo : veicoli) {
            System.out.println("Descrizione: "+veicolo.getDescription());
        }
    }


    public void showMenu(){
        System.out.println("\n\n==== MENU ====");
        System.out.println("1. Produci Auto");
        System.out.println("2. Produci Moto");
        System.out.println("3. Visualizza veicoli");
        System.out.println("0. Esci");
    }

}
