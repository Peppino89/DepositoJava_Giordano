package view;

import model.Ticket;
import utility.InputUtility;

import java.util.ArrayList;

public class MenuView {

    //====== MENU INIZIALE ======
    public int mostraMenuIniziale() {
        System.out.println("\n==== SISTEMA TICKET ====");
        System.out.println("1. Registrazione utente");
        System.out.println("2. Login utente");
        System.out.println("0. Esci");

        return InputUtility.leggiIntero("Scelta: ");
    }

    //====== MENU UTENTE ======
    public int mostraMenuUtente() {
        System.out.println("\n===== MENU UTENTE =====");
        System.out.println("1. Crea ticket");
        System.out.println("2. Visualizza i miei ticket");
        System.out.println("0. Logout");

        return InputUtility.leggiIntero("Scelta: ");
    }

    // ===== MENU ADMIN =====
    public int mostraMenuAdmin() {
        System.out.println("\n===== MENU ADMIN =====");
        System.out.println("1. Visualizza tutti i ticket");
        System.out.println("2. Modifica ticket completo");
        System.out.println("3. Modifica singolo campo");
        System.out.println("4. Elimina ticket");
        System.out.println("5. Risolvi ticket");
        System.out.println("0. Logout");

        return InputUtility.leggiIntero("Scelta: ");
    }

    // ===== STAMPA TICKETS =====
    public void stampaTickets(ArrayList<Ticket> tickets) {

        if (tickets.isEmpty()) {
            System.out.println("Nessun ticket trovato.");
            return;
        }

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    // ===== STAMPA MESSAGGI =====
    public void stampaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
}