package service;

import model.Ticket;
import model.UtenteObserver;

import java.util.ArrayList;

// Facade
public class TicketFacade {

    private AuthService authService;
    private TicketService ticketService;

    public TicketFacade() {
        this.authService = AuthService.getInstance();
        this.ticketService = TicketService.getInstance();
    }

    public boolean registraUtente(String nomeUtente, String password) {
        return authService.registraUtente(nomeUtente, password);
    }

    public UtenteObserver login(String nomeUtente, String password) {
        return authService.loginUtente(nomeUtente, password);
    }

    public void registraUtenteObserver(UtenteObserver utente) {
        ticketService.registraUtenteObserver(utente);
    }

    public void creaTicket(String titolo, String descrizione, String autore) {
        ticketService.creaTicket(titolo, descrizione, autore);
    }

    public ArrayList<Ticket> visualizzaTuttiTicket() {
        return ticketService.getTickets();
    }

    public ArrayList<Ticket> visualizzaTicketUtente(String autore) {
        return ticketService.getTicketsByAutore(autore);
    }

    public boolean modificaTicketCompleto(int id, String titolo, String descrizione, String stato) {
        return ticketService.modificaTicket(id, titolo, descrizione, stato);
    }

    public boolean modificaSingoloCampo(int id, String campo, String nuovoValore) {
        return ticketService.modificaTicket(id, campo, nuovoValore);
    }

    public boolean eliminaTicket(int id) {
        return ticketService.eliminaTicket(id);
    }

    public boolean risolviTicket(int id) {
        return ticketService.risolviTicket(id);
    }
}