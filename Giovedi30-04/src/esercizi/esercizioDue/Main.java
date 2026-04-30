package esercizi.esercizioDue;

import java.util.Scanner;

// Classe principale con menu interattivo
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Creazione del Subject
        AgenziaBorsa agenzia = new AgenziaBorsa();

        // Creazione di alcuni observer iniziali
        Investitore privato = new InvestitorePrivato("Marco");
        Investitore banca = new InvestitoreBancario("Intesa");

        // Registrazione degli observer
        agenzia.aggiungiInvestitore(privato);
        agenzia.aggiungiInvestitore(banca);

        Utente utenteLoggato = null;
        boolean programmaAttivo = true;

        // Menu iniziale
        while (programmaAttivo) {
            System.out.println("\n--- MENU INIZIALE ---");
            System.out.println("1. Registrati");
            System.out.println("2. Login");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    // Registrazione utente
                    System.out.print("Inserisci username: ");
                    String usernameReg = input.nextLine();

                    System.out.print("Inserisci password: ");
                    String passwordReg = input.nextLine();

                    Utente.registrati(usernameReg, passwordReg);
                    break;

                case 2:
                    // Login utente
                    System.out.print("Inserisci username: ");
                    String usernameLogin = input.nextLine();

                    System.out.print("Inserisci password: ");
                    String passwordLogin = input.nextLine();

                    utenteLoggato = Utente.login(usernameLogin, passwordLogin);

                    // Se login corretto, aggiunge l'utente come observer
                    if (utenteLoggato != null) {
                        agenzia.aggiungiInvestitore(utenteLoggato);
                        menuUtente(input, agenzia, utenteLoggato);
                    }
                    break;

                case 0:
                    programmaAttivo = false;
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        input.close();
    }

    // Menu dopo il login
    public static void menuUtente(Scanner input, AgenziaBorsa agenzia, Utente utente) {

        boolean loggato = true;

        while (loggato) {
            System.out.println("\n--- MENU UTENTE ---");
            System.out.println("1. Aggiorna valore azione");
            System.out.println("2. Rimuovi utente dagli investitori");
            System.out.println("3. Logout");
            System.out.print("Scelta: ");

            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    // Aggiornamento valore azione → notifica a tutti
                    System.out.print("Nome azione: ");
                    String nomeAzione = input.nextLine();

                    System.out.print("Nuovo valore: ");
                    double valore = input.nextDouble();
                    input.nextLine();

                    agenzia.aggiornaValoreAzione(nomeAzione, valore);
                    break;

                case 2:
                    // Rimozione dell'utente dagli observer
                    agenzia.rimuoviInvestitore(utente);
                    break;

                case 3:
                    // Logout e rimozione dalle notifiche
                    agenzia.rimuoviInvestitore(utente);
                    System.out.println("Logout effettuato.");
                    loggato = false;
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}