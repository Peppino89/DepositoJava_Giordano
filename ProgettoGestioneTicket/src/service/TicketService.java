package service;

import model.*;

import java.util.ArrayList;

// Singleton e Subject
public class TicketService {

    private static TicketService instance;
    private TicketNotifier notifier;

    private ArrayList<Ticket> tickets;
    private ArrayList<Observer> utentiRegistrati;

    private int nextId;

    private TicketService() {

        this.notifier = new TicketNotifier();

        this.notifier.aggiungiObserver(new Admin("admin", "admin123"));

        this.tickets = new ArrayList<>();
        this.utentiRegistrati = new ArrayList<>();

        this.nextId = 1;
    }

    public static TicketService getInstance() {
        if (instance == null) {
            instance = new TicketService();
        }
        return instance;
    }

    public void registraUtenteObserver(UtenteObserver utente) {
        if (!utenteGiaRegistrato(utente.getNomeUtente())) {
            this.utentiRegistrati.add(utente);
        }
    }

    private boolean utenteGiaRegistrato(String nomeUtente) {
        for (Observer observer : utentiRegistrati) {

            if (observer instanceof UtenteObserver) {
                UtenteObserver utente = (UtenteObserver) observer;

                if (utente.getNomeUtente().equals(nomeUtente)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void creaTicket(String titolo, String descrizione, String autore) {

        Ticket ticket = new Ticket(nextId, titolo, descrizione, autore);

        this.tickets.add(ticket);

        this.notifier.notifica(
                "Nuovo ticket creato: ID " + ticket.getId() + " - " + ticket.getTitolo()
        );

        nextId++;
    }

    public ArrayList<Ticket> getTickets() {
        return new ArrayList<>(this.tickets);
    }

    public ArrayList<Ticket> getTicketsByAutore(String autore) {

        ArrayList<Ticket> risultati = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getAutore().equals(autore)) {
                risultati.add(ticket);
            }
        }

        return risultati;
    }

    private Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }

        return null;
    }

    private Observer getObserverByNome(String nomeUtente) {
        for (Observer observer : utentiRegistrati) {

            if (observer instanceof UtenteObserver) {
                UtenteObserver utente = (UtenteObserver) observer;

                if (utente.getNomeUtente().equals(nomeUtente)) {
                    return observer;
                }
            }
        }

        return null;
    }

    public boolean modificaTicket(int id, String titolo, String descrizione, String stato) {

        Ticket ticket = getTicketById(id);

        if (ticket == null) {
            return false;
        }

        ticket.setTitolo(titolo);
        ticket.setDescrizione(descrizione);
        ticket.setStatus(stato.toUpperCase());

        this.notifier.notifica("Ticket modificato: ID " + ticket.getId());

        return true;
    }

    public boolean modificaTicket(int id, String campo, String nuovoValore) {

        Ticket ticket = getTicketById(id);

        if (ticket == null) {
            return false;
        }

        if (campo.equalsIgnoreCase("titolo")) {
            ticket.setTitolo(nuovoValore);
        } else if (campo.equalsIgnoreCase("descrizione")) {
            ticket.setDescrizione(nuovoValore);
        } else if (campo.equalsIgnoreCase("stato")) {
            ticket.setStatus(nuovoValore.toUpperCase());
        } else {
            System.err.println("Campo non valido");
            return false;
        }

        this.notifier.notifica(
                "Ticket aggiornato: ID " + ticket.getId() + " | Campo modificato: " + campo
        );

        return true;
    }

    public boolean eliminaTicket(int id) {

        Ticket ticket = getTicketById(id);

        if (ticket == null) {
            return false;
        }

        tickets.remove(ticket);

        this.notifier.notifica("Ticket eliminato: ID " + id);

        return true;
    }

    public boolean risolviTicket(int id) {

        Ticket ticket = getTicketById(id);

        if (ticket == null) {
            return false;
        }

        ticket.setStatus("RISOLTO");

        Observer autoreTicket = getObserverByNome(ticket.getAutore());

        if (autoreTicket != null) {
            autoreTicket.update(
                    "Il tuo ticket ID " + ticket.getId() + " è stato risolto."
            );
        }

        return true;
    }
}