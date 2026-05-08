package service;

import model.Ticket;
import java.util.ArrayList;
import java.util.stream.Collectors;

//Singleton
public class TicketService {

    private static TicketService instance;

    private ArrayList<Ticket> tickets;
    private int nextId; //Mi serve per generare automaticamente un ID univoco per ogni ticket.

    private TicketService(){
        this.tickets = new ArrayList<>();
        this.nextId = 1;//lo faccio partire da 1
    }

    public static TicketService getInstance(){
        if(instance == null){
            instance = new TicketService();
        }
        return instance;
    }

    public void creaTicket(String titolo, String descrizione, String autore){

        Ticket ticket = new Ticket(nextId,titolo,descrizione,autore);

        this.tickets.add(ticket);

        nextId++;// viene incrementato per il prossimo ticked che verrà creato

    }

    public ArrayList<Ticket> getTickets(){
        return new ArrayList<>(this.tickets);// creo una copia dell'array list
    }

    public ArrayList<Ticket> getTicketsByAutore(String autore){


        ArrayList<Ticket> risultati = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getAutore().equals(autore)) {
                risultati.add(ticket);
            }
        }

        return risultati;
    }

    public Ticket getTicketById(int id){
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public boolean modificaTicket(int id, String titolo, String descrizione){
        Ticket ticket = getTicketById(id);

        if(ticket == null){
            return false; // vuol dire che non ha trovato l'utente
        }

        ticket.setTitolo(titolo);
        ticket.setDescrizione(descrizione);
        return true;
    }

    public boolean modificaTicket(int id, String titolo){
        Ticket ticket = getTicketById(id);

        if(ticket == null){
            return false; // vuol dire che non ha trovato l'utente
        }

        ticket.setTitolo(titolo);
        ticket.setStatus("IN_LAVORAZIONE");
        return true;
    }



    public boolean eliminaTicket(int id){
        Ticket ticket = getTicketById(id);
        if(ticket == null){
            return false;
        }

        tickets.remove(ticket);
        return true;
    }

    public boolean risolviTicket(int id){
        Ticket ticket = getTicketById(id);

        if(ticket == null){
            return false;
        }

        ticket.setStatus("RISOLTO");
        return true;
    }







}
