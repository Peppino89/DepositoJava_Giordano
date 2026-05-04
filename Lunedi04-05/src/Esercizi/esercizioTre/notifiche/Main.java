package Esercizi.esercizioTre.notifiche;


import java.util.Scanner;

/**
 * Classe principale dell'applicazione.
 *
 * Tutte le operazioni vengono gestite da tastiera:
 * - registrazione utente
 * - scelta delle decorazioni della notifica
 * - invio notifica
 * - visualizzazione utenti registrati
 * - rimozione utente
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Otteniamo l'unica istanza del Singleton.
        NotificationManager manager = NotificationManager.getInstance();

        boolean start = true;

        while (start) {
            System.out.println("\n===== PIATTAFORMA NOTIFICHE =====");
            System.out.println("1. Registra nuovo utente");
            System.out.println("2. Invia notifica");
            System.out.println("3. Mostra utenti registrati");
            System.out.println("4. Rimuovi utente");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            int scelta = leggiIntero(input);

            switch (scelta) {
                case 1:
                    registraUtente(input, manager);
                    break;

                case 2:
                    inviaNotifica(input, manager);
                    break;

                case 3:
                    manager.mostraUtentiRegistrati();
                    break;

                case 4:
                    rimuoviUtente(input, manager);
                    break;

                case 5:
                    start = false;
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        input.close();
    }

    /**
     * Registra un nuovo utente e gli assegna una personalizzazione della notifica.
     */
    private static void registraUtente(Scanner input, NotificationManager manager) {
        System.out.print("Inserisci nome utente: ");
        String nome = input.nextLine();

        // Creiamo la catena di decorator scelta da tastiera.
        Notifica notifica = creaDecorazioni(input);

        Utente utente = new Utente(nome, notifica);
        manager.registra(utente);

        System.out.println("Utente registrato correttamente.");
    }

    /**
     * Permette all'utente di scegliere una o più decorazioni.
     *
     * Ogni volta che viene scelta una decorazione, la variabile notifica
     * viene "avvolta" in un nuovo decorator.
     */
    private static Notifica creaDecorazioni(Scanner input) {
        Notifica notifica = new NotificaBase();

        boolean continua = true;

        while (continua) {
            System.out.println("\n--- Personalizza notifica ---");
            System.out.println("1. Aggiungi timestamp");
            System.out.println("2. Converti in maiuscolo");
            System.out.println("3. Converti in minuscolo");
            System.out.println("4. Aggiungi prefisso");
            System.out.println("5. Aggiungi emoji");
            System.out.println("6. Fine personalizzazione");
            System.out.print("Scelta: ");

            int scelta = leggiIntero(input);

            switch (scelta) {
                case 1:
                    notifica = new TimestampDecorator(notifica);
                    System.out.println("Timestamp aggiunto.");
                    break;

                case 2:
                    notifica = new MaiuscoloDecorator(notifica);
                    System.out.println("Maiuscolo aggiunto.");
                    break;

                case 3:
                    notifica = new MinuscoloDecorator(notifica);
                    System.out.println("Minuscolo aggiunto.");
                    break;

                case 4:
                    System.out.print("Inserisci prefisso: ");
                    String prefisso = input.nextLine();
                    notifica = new PrefissoDecorator(notifica, prefisso);
                    System.out.println("Prefisso aggiunto.");
                    break;

                case 5:
                    System.out.print("Inserisci emoji: ");
                    String emoji = input.nextLine();
                    notifica = new EmojiDecorator(notifica, emoji);
                    System.out.println("Emoji aggiunta.");
                    break;

                case 6:
                    continua = false;
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        return notifica;
    }

    /**
     * Legge da tastiera il messaggio e lo invia tramite il manager.
     */
    private static void inviaNotifica(Scanner input, NotificationManager manager) {
        System.out.print("Inserisci messaggio da inviare: ");
        String messaggio = input.nextLine();

        manager.inviaNotifica(messaggio);
    }

    /**
     * Rimuove un utente scegliendolo dalla lista stampata a video.
     */
    private static void rimuoviUtente(Scanner input, NotificationManager manager) {
        manager.mostraUtentiRegistrati();

        System.out.print("Inserisci numero utente da rimuovere: ");
        int indice = leggiIntero(input) - 1;

        boolean rimosso = manager.rimuoviUtentePerIndice(indice);

        if (rimosso) {
            System.out.println("Utente rimosso correttamente.");
        } else {
            System.out.println("Indice non valido.");
        }
    }

    /**
     * Metodo di utilità per leggere un intero da Scanner evitando crash
     * quando l'utente inserisce testo al posto di un numero.
     */
    private static int leggiIntero(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Devi inserire un numero.");
            input.nextLine();
            System.out.print("Riprova: ");
        }

        int numero = input.nextInt();

        // Consuma il carattere di invio rimasto nel buffer.
        input.nextLine();

        return numero;
    }
}
