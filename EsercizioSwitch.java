package operatoriConfronto;

import java.util.Scanner;

public class EsercizioSwitch {
    public static void main(String[] args) {

        // Creazione dello scanner per leggere un numero da tastiera
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Inserisci un numero e ti dirò che giorno è:");
        // Lettura del numero inserito dall'utente (giorno della settimana)
        int rispDay = scannerInt.nextInt();

        // Struttura switch per controllare il valore inserito
        switch (rispDay) {
            case 1:
                System.out.println("Lunedì"); // Se inserisce 1
                break;
            case 2:
                System.out.println("Martedì"); // Se inserisce 2
                break;
            case 3:
                System.out.println("Mercoledì"); // Se inserisce 3
                break;
            case 4:
                System.out.println("Giovedì"); // Se inserisce 4
                break;
            case 5:
                System.out.println("Venerdì"); // Se inserisce 5
                break;
            case 6:
                System.out.println("Sabato"); // Se inserisce 6
                break;
            case 7:
                System.out.println("Domenica"); // Se inserisce 7
                break;
            default:
                System.out.println("Giorno non valido"); // Se il numero non è tra 1 e 7
        }

        // Chiusura dello scanner (buona pratica)
        scannerInt.close();

    }
}
