package controller;

import model.Ticket;
import model.UtenteObserver;
import service.TicketFacade;

import java.util.ArrayList;

public class TicketController {

    private TicketFacade ticketFacade;

    public TicketController() {
        this.ticketFacade = new TicketFacade();
    }

    public boolean registraUtente(String nomeUtente, String password) {
        return ticketFacade.registraUtente(nomeUtente, password);
    }

    public UtenteObserver loginUtente(String nomeUtente, String password) {
        return ticketFacade.login(nomeUtente, password);
    }

    public void registraUtenteObserver(UtenteObserver utente) {
        ticketFacade.registraUtenteObserver(utente);
    }

    public void creaTicket(String titolo, String descrizione, String autore) {
        ticketFacade.creaTicket(titolo, descrizione, autore);
    }

    public ArrayList<Ticket> visualizzaTuttiTickets() {
        return ticketFacade.visualizzaTuttiTicket();
    }

    public ArrayList<Ticket> visualizzaTicketsUtente(String nomeUtente) {
        return ticketFacade.visualizzaTicketUtente(nomeUtente);
    }

    public boolean modificaTicketCompleto(int id, String titolo, String descrizione, String status) {
        return ticketFacade.modificaTicketCompleto(id, titolo, descrizione, status);
    }

    public boolean modificaTicketSingoloCampo(int id, String campo, String nuovoValore) {
        return ticketFacade.modificaSingoloCampo(id, campo, nuovoValore);
    }

    public boolean eliminaTicket(int id) {
        return ticketFacade.eliminaTicket(id);
    }

    public boolean risolviTicket(int id) {
        return ticketFacade.risolviTicket(id);
    }
}