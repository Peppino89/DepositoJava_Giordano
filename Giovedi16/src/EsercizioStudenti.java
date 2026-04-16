import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioStudenti {

    public static void main(String[] args) {

        // Scanner per leggere input da tastiera
        Scanner input = new Scanner(System.in);

        // Lista per salvare i nomi degli studenti
        ArrayList<String> nomi = new ArrayList<>();

        String nome;

        // Ciclo per inserire i nomi finché l'utente non scrive "fine"
        while (true) {
            System.out.println("Inserisci un nome (scrivi 'fine' per terminare): ");
            nome = input.nextLine();

            // Controllo per uscire dal ciclo
            if (nome.equalsIgnoreCase("fine")) {
                break;
            }

            // Aggiungo il nome alla lista
            nomi.add(nome);
        }

        // Stampo il numero totale di studenti inseriti
        System.out.println("Numero studenti inseriti: " + nomi.size());

        // Chiedo il tipo di ordinamento
        System.out.println("Vuoi ordine crescente o decrescente?");
        String tipo = input.nextLine();

        // Ordinamento della lista
        if (tipo.equalsIgnoreCase("crescente")) {

            // Ordine alfabetico (A-Z)
            Collections.sort(nomi);

        } else if (tipo.equalsIgnoreCase("decrescente")) {

            // Ordine alfabetico inverso (Z-A) prima lo faccio in ordine alfabetico crescente e poi lo inverto
            Collections.sort(nomi);
            Collections.reverse(nomi);

        } else {

            // Caso di input non valido → uso default crescente
            System.out.println("Scelta non valida, uso ordine crescente.");
            Collections.sort(nomi);
        }

        // Stampo la lista ordinata
        System.out.println("Lista studenti:");
        for (String n : nomi) {
            System.out.println(n);
        }

        // Ciclo per eliminare studenti dalla lista
        while (true) {

            System.out.println("Vuoi eliminare uno studente? (s/n)");
            String scelta = input.nextLine();

            if (scelta.equalsIgnoreCase("s")) {

                // Chiedo il nome da eliminare
                System.out.println("Inserisci il nome da eliminare:");
                String daEliminare = input.nextLine();

                // remove() ritorna true se l'elemento è stato trovato e rimosso
                if (nomi.remove(daEliminare)) {
                    System.out.println("Studente rimosso.");
                } else {
                    System.out.println("Studente non trovato.");
                }

            } else if (scelta.equalsIgnoreCase("n")) {

                // Esco dal ciclo
                break;
            }
        }

        // Stampo la lista aggiornata
        System.out.println("Lista aggiornata:");
        for (String n : nomi) {
            System.out.println(n);
        }

        // Chiudo lo scanner
        input.close();
    }
}