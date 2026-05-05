package Esercizio.controller;

import Esercizio.model.*;
import Esercizio.view.ConsoleView;

import java.util.Scanner;

public class FabbricaController {

    private Fabbrica fabbrica;
    private ConsoleView consoleView;
    private Scanner scanner;

    public FabbricaController() {
        this.fabbrica = Fabbrica.getInstance();
        this.consoleView = new ConsoleView();
        this.scanner = new Scanner(System.in);

        //Registro la view nell' Observer
        fabbrica.addObserver(this.consoleView);
    }


    public void inizia(){
        int scelta;

        do{

          consoleView.showMenu();
          scelta = scanner.nextInt();
          scanner.nextLine();//pulizia del buffer dato che ho usato nexInt

          switch (scelta){
              case 1:
                       creaMacchina();
                       break;
              case 2:
                      creaMoto();
                   break;
              case 3: consoleView.mostraVeicoli(fabbrica.getVeicoli());
                   break;
              case 0: System.out.println("Sei uscito dal programma");
                   break;
              default:System.out.println("Scelta non valida ");
          }

        }while(scelta!=0);
    }


    private void creaMacchina(){
        Veicolo macchina = new Macchina();
        System.out.println("Vuoi inserire qualche accessorio? (y/n) ");

        String risp=scanner.nextLine();

        if(risp.equals("y")){
            System.out.println("Inserisci l'accessorio che vuoi inserire: ");
            String accessorio = scanner.nextLine();
            macchina = new AccessoriDecorator(macchina,accessorio);
        }

        fabbrica.produciVeicolo(macchina);
    }

    private void creaMoto(){
        Veicolo moto = new Moto();
        System.out.println("Vuoi inserire qualche accessorio? (y/n) ");

        String risp=scanner.nextLine();

        if(risp.equals("y")){
            System.out.println("Inserisci l'accessorio che vuoi inserire: ");
            String accessorio = scanner.nextLine();
            moto = new AccessoriDecorator(moto,accessorio);
        }

        fabbrica.produciVeicolo(moto);


    }
}
