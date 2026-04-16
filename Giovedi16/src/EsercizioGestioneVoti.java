import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioGestioneVoti {

    public static void main(String[] args) {

        // Lista per salvare i voti inseriti dall'utente
        ArrayList<Integer> voti = new ArrayList();

        // Scanner per leggere input da tastiera
        Scanner input = new Scanner(System.in);

        // Chiedo quanti voti inserire
        System.out.println("Quanti voti vuoi inserire ");
        int numVoti = input.nextInt();

        // Ciclo per inserire i voti uno alla volta
        for (int i = 1; i <= numVoti; i++) {

            System.out.println("Inserisci il voto: ");
            int voto = input.nextInt();

            // Aggiungo il voto alla lista
            voti.add(voto);
        }

        // Ciclo infinito per mostrare il menu finché l'utente non esce
        while(true){

            // Menu delle operazioni disponibili
            System.out.println("Digita 1 per Calcolare la media dei voti: ");
            System.out.println("Digita 2 per mostrare il voto più alto ");
            System.out.println("Digita 3 per Calcolare il voto più basso: ");
            System.out.println("Digita 4 per Verificare la promozioni ");

            // Leggo la scelta dell'utente
            int risposta = input.nextInt();

            // Serve per consumare il newline rimasto nel buffer
            input.nextLine();

            // Switch per gestire le varie operazioni
            switch(risposta){

                case 1:
                    // Calcolo e stampo la media
                    System.out.println("Media voti: "+ calcolaMedia(voti));
                    break;

                case 2:
                    // Trovo e stampo il voto massimo
                    System.out.println("Voto Alto: "+votoMax(voti));
                    break;

                case 3:
                    // Trovo e stampo il voto minimo
                    System.out.println("Voto Basso: "+votoMin(voti));
                    break;

                case 4:
                    // Verifico se lo studente è promosso in base alla media
                    System.out.println("Promozione: "+verificaPromozione(calcolaMedia(voti)));
                    break;

                default:
                    // Caso di input non valido
                    System.out.println("Risposta non valida");
                    break;
            }

            // Chiedo se l'utente vuole continuare
            System.out.println("vuoi continuare s/n: ");
            String rispContinua = input.nextLine();

            // Se l'utente scrive "n" esco dal ciclo
            if(rispContinua.equals("n")){
                break;
            }
        }

        // Messaggio finale
        System.out.println("Sei uscito dal programma: ");
    }

    // Metodo per calcolare la media dei voti
    public static double calcolaMedia(ArrayList<Integer> listaVoti){

        double sommaVoti = 0;

        // Sommo tutti i voti presenti nella lista
        for(Integer voto : listaVoti){
            sommaVoti += voto;
        }

        // Ritorno la media
        return sommaVoti / listaVoti.size();
    }

    // Metodo per trovare il voto massimo
    public static int votoMax(ArrayList<Integer> listaVoti){

        // Inizializzo max con il primo elemento della lista
        int max = listaVoti.get(0);

        // Scorro la lista per trovare il valore più alto
        for(Integer voto : listaVoti){
            if(voto > max){
                max = voto;
            }
        }

        return max;
    }

    // Metodo per trovare il voto minimo
    public static int votoMin(ArrayList<Integer> listaVoti){

        // Inizializzo min con il primo elemento della lista
        int min = listaVoti.get(0);

        // Scorro la lista per trovare il valore più basso
        for(Integer voto : listaVoti){
            if(voto < min){
                min = voto;
            }
        }

        return min;
    }

    // Metodo per verificare se lo studente è promosso
    public static String verificaPromozione(double media){

        // Se la media è maggiore o uguale a 6 → promosso
        if(media >= 6){
            return "Promosso";
        }else{
            return "Bocciato";
        }
    }
}