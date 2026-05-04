package Esercizi.esercizioUno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci un messaggio ");

        String inputMessagge = input.nextLine();

        //Messaggio Base
        Messaggio messaggio = new MessaggioBase(inputMessagge);

        //Decorazione
        Messaggio messaggioMaiuscolo = new DecoratoreEsclamativo(new DecoratorMaiuscolo(messaggio));

        System.out.println("Messaggio Maiuscolo: "+messaggioMaiuscolo.getContenuto());





    }
}
