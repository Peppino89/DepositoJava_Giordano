package operatoriConfronto;

import java.util.Scanner;

public class EsercizioIFScanner {
    public static void main(String[] args) {

        // Creo un solo Scanner per leggere numeri e testo
        Scanner scanner = new Scanner(System.in);

        // Chiedo all'utente quanti anni ha
        System.out.print("Ciao, quanti anni hai? ");
        int rispAnni = scanner.nextInt();


        // Chiedo se possiede un biglietto valido
        System.out.print("Possiedi un biglietto valido? Rispondi si o no: ");
        String rispBigliettoValido = scanner.nextLine();
        String textBigliettoValido;

        // Controllo la risposta sul biglietto
        if (rispBigliettoValido.equalsIgnoreCase("si")) {
            textBigliettoValido = "Ok, il tuo biglietto è valido";
        } else {
            textBigliettoValido = "No, mi dispiace, il biglietto non è valido";
        }

        // Chiedo se è accompagnato da un adulto
        System.out.print("Sei accompagnato da un adulto? Rispondi si o no: ");
        String rispAccompagnatoAdulto = scanner.nextLine();
        String textAccompagnatoAdulto;

        // Controllo la risposta sull'adulto accompagnatore
        if (rispAccompagnatoAdulto.equalsIgnoreCase("si")) {
            textAccompagnatoAdulto = "Ok, sei con un adulto";
        } else {
            textAccompagnatoAdulto = "No, non sei con un adulto";
        }

        // Chiedo se ha acquistato l'opzione salta fila
        System.out.print("Hai acquistato l'opzione 'Salta la fila'? Rispondi si o no: ");
        String rispSaltaFila = scanner.nextLine();
        String textSaltaFila;

        // Controllo la risposta sull'opzione salta fila
        if (rispSaltaFila.equalsIgnoreCase("si")) {
            textSaltaFila = "Ok, hai acquistato il salta fila";
        } else {
            textSaltaFila = "No, non hai acquistato il salta fila";
        }

        // Stampo tutte le risposte finali
        System.out.println("\nEcco le risposte:");
        System.out.println("Anni: " + rispAnni);
        System.out.println("Biglietto: " + textBigliettoValido);
        System.out.println("Accompagnato: " + textAccompagnatoAdulto);
        System.out.println("Salta fila: " + textSaltaFila);

        // Chiudo lo scanner
        scanner.close();
    }

    }


