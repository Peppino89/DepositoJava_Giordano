package utility;

import java.util.Scanner;

//Classe Utility per leggere l'
public class InputUtility {
    private static Scanner input = new Scanner(System.in);


    public static String leggiStringa(String messaggio) {
        System.out.print(messaggio);
        return input.nextLine();
    }

    public static int leggiIntero(String messaggio) {
        System.out.print(messaggio);

        while (!input.hasNextInt()) {
            System.out.println("Inserisci un numero valido.");
            input.next();
        }

        int numero = input.nextInt();
        input.nextLine();

        return numero;
    }
}
