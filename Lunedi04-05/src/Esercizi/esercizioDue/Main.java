package Esercizi.esercizioDue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Hamburger hamburger = new BaseBurger();
        System.out.println("Ciao cosa ci vuoi sul panino scegli: ");
        System.out.println("1. Formaggio");
        System.out.println("2. Bacon2");
        System.out.println("3. Entrambi");

        int scelta = input.nextInt();

//        while (scelta<1 || scelta>3) {
//            System.out.println("Scegli un numero valido");
//            scelta = input.nextInt();
//        }

        switch (scelta) {
            case 1:
                hamburger = new FormaggioDecorator(hamburger);
                System.out.println("Panino con: "+hamburger.getDescrizione()+" prezzo: "+hamburger.getPrezzo() );
                break;
                case 2:
                    hamburger = new BaconDecorator(hamburger);
                    System.out.println("Panino con: "+hamburger.getDescrizione()+" prezzo: "+hamburger.getPrezzo() );
                    break;
                case 3:
                    hamburger = new FormaggioDecorator(new BaconDecorator(hamburger));
                    System.out.println("Panino con: "+hamburger.getDescrizione()+" prezzo: "+hamburger.getPrezzo() );
                    break;
                default:System.out.println("Scelta non valida rifare l'operazione");
        }

    }
}
