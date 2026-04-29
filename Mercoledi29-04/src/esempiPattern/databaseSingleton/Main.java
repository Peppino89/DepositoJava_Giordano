package esempiPattern.databaseSingleton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Ottengo l'unica istanza del DB (Singleton)
        DatabaseManager db = DatabaseManager.getInstance();

        //Mi serve per dimostrare che sia sempre la stessa istanza
        System.out.println("Stessa istanza? " + (db == DatabaseManager.getInstance()));

        Scanner scanner = new Scanner(System.in);
        boolean inizioProgramma = true;

        while (inizioProgramma) {

            //Menu utente
            System.out.println("\n=== MENU ===");
            System.out.println("1. Salva utente");
            System.out.println("2. Mostra utenti");
            System.out.println("3. Totale connessioni");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    // Simulo connessione per operazione di scrittura
                    db.connect();

                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();

                    //Salvo utente nel DB
                    db.salvaUtente(new Utente(nome));

                    System.out.println("Utente salvato!");
                    break;

                case 2:
                    //Simulo connessione per operazione di lettura
                    db.connect();

                    // Controllo se ci sono dati
                    if (db.getUtenti().isEmpty()) {
                        System.out.println("Nessun utente presente.");
                    } else {
                        System.out.println("Lista utenti:");
                        // Stampo tutti gli utenti
                        for (Utente u : db.getUtenti()) {
                            System.out.println(u);
                        }
                    }
                    break;

                case 3:
                    //Mostro numero totale connessioni
                    System.out.println("Totale connessioni: " + db.getConnectionCount());
                    break;

                case 4:

                    inizioProgramma = false;
                    System.out.println("Programma Terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }

        scanner.close();
    }
}