package sistema;

import java.util.Scanner;

public class EsercizioArrayPasticceria {

    public static void main(String[] args) {
        // Array con i nomi dei dolci disponibili nel menu
        String[] nomiDolciMenu = {"Babà","Ricotta e pera","Cannolo siciliano","Mille sfoglie"};

        // Array con i prezzi corrispondenti ai dolci (stessa posizione dell'array sopra)
        int[] prezzoDolci = {2,1,3,2};

        // Array per salvare i nomi dei dolci ordinati (max 10)
        String[] nomeDolceOrdinato = new String[10];

        // Array per salvare i prezzi dei dolci ordinati
        int[] prezzoDolceOrdinato = new int[10];

        // Variabile per il totale finale
        int totale = 0;

        // Scanner per leggere input da tastiera
        Scanner input = new Scanner(System.in);

        // Chiedo all’utente quanti dolci vuole ordinare
        System.out.print("Quanti dolci vuoi ordinare: ");
        int numDolci = input.nextInt();

       

        // Controllo che il numero inserito sia tra 1 e 10
        while (numDolci > 10 || numDolci <= 0) {
            System.out.print("Puoi ordinare da 1 a 10 dolci massimo: ");
            numDolci = input.nextInt();
        }

        // Ciclo per inserire ogni dolce ordinato
        for (int i = 0; i < numDolci; i++) {

            System.out.print("Scegli il dolce " + (i + 1) + "\n");

            // Stampo il menu con indice + nome + prezzo
            for (int j = 0; j < nomiDolciMenu.length; j++) {
                System.out.println(" Digita " + j + " per " + nomiDolciMenu[j] + " - prezzo " + prezzoDolci[j]);
            }

            // Leggo la scelta dell’utente
            int rispDolce = input.nextInt();

            // Controllo che la scelta sia valida (indice corretto)
            while (rispDolce < 0 || rispDolce >= nomiDolciMenu.length) {
                System.out.println("Numero non valido ");
                rispDolce = input.nextInt();
            }

            // Salvo il nome del dolce scelto
            nomeDolceOrdinato[i] = nomiDolciMenu[rispDolce];

            // Salvo il prezzo del dolce scelto
            prezzoDolceOrdinato[i] = prezzoDolci[rispDolce];
        }

        // Stampa degli ordini effettuati
        System.out.println("\nOrdini effettuati:");

        for (int i = 0; i < numDolci; i++) {
            System.out.println(nomeDolceOrdinato[i] + " - prezzo: " + prezzoDolceOrdinato[i]);

            // Sommo il prezzo al totale
            totale += prezzoDolceOrdinato[i];
        }

        // Stampa totale finale
        System.out.println("Totale: " + totale + " euro");

        // Chiusura dello scanner
        input.close();


    }
}
