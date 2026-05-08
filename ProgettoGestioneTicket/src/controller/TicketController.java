package controller;

import service.AuthService;
import service.TicketService;

public class TicketController {

    private AuthService auth;
    private TicketService ticket;

    public TicketController() {
        this.auth = AuthService.getInstance();
        this.ticket = TicketService.getInstance();

    }

    public boolean registraUtente
}
