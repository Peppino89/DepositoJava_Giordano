package esercizi.esercizioTre;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principale con gestione menu e utenti
public class Main {

    public static void main(String[] args) {

        // Scanner per input da tastiera
        Scanner input = new Scanner(System.in);

        // Lista utenti registrati sulla piattaforma
        ArrayList<User> users = new ArrayList<>();

        // Istanza Singleton del gestore notifiche
        NotificationManager manager = NotificationManager.getInstance();

        int scelta;

        // Menu iniziale
        do {
            System.out.println("\n--- MENU INIZIALE ---");
            System.out.println("1. Registrati alla piattaforma");
            System.out.println("2. Login");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    // Registrazione utente
                    registrazione(input, users);
                    break;

                case 2:
                    // Login utente
                    User loggedUser = login(input, users);

                    // Se login corretto, entra nel menu utente
                    if (loggedUser != null) {
                        menuUtente(input, loggedUser, manager);
                    }
                    break;

                case 0:
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        input.close();
    }

    // Metodo per registrare un nuovo utente
    private static void registrazione(Scanner input, ArrayList<User> users) {

        System.out.print("Inserisci username: ");
        String username = input.nextLine();

        // Controllo se username già esiste
        if (trovaUtente(users, username) != null) {
            System.out.println("Username già esistente.");
            return;
        }

        System.out.print("Inserisci password: ");
        String password = input.nextLine();

        // Creazione nuovo utente
        User nuovoUtente = new User(username, password);
        users.add(nuovoUtente);

        System.out.println("Utente registrato correttamente.");
    }

    // Metodo per effettuare il login
    private static User login(Scanner input, ArrayList<User> users) {

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        User user = trovaUtente(users, username);

        // Controllo credenziali
        if (user != null && user.checkPassword(password)) {
            System.out.println("Login effettuato. Benvenuto " + user.getUsername() + "!");
            return user;
        }

        System.out.println("Credenziali non valide.");
        return null;
    }

    // Menu dopo il login
    private static void menuUtente(
            Scanner input,
            User user,
            NotificationManager manager
    ) {

        int scelta;

        do {
            System.out.println("\n--- MENU UTENTE: " + user.getUsername() + " ---");
            System.out.println("1. Iscriviti alle notifiche");
            System.out.println("2. Cancellati dalle notifiche");
            System.out.println("3. Pubblica nuovo avviso");
            System.out.println("0. Logout");
            System.out.print("Scelta: ");

            scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    // Iscrizione alle notifiche
                    manager.register(user);
                    break;

                case 2:
                    // Disiscrizione dalle notifiche
                    manager.unregister(user);
                    break;

                case 3:
                    // Pubblicazione di un nuovo avviso
                    System.out.print("Inserisci testo dell'avviso: ");
                    String message = input.nextLine();
                    manager.publishNotification(message);
                    break;

                case 0:
                    System.out.println("Logout effettuato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
    }

    // Metodo per cercare un utente nella lista
    private static User trovaUtente(ArrayList<User> users, String username) {

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }
}