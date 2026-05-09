import controller.TicketController;
import model.UtenteObserver;
import utility.InputUtility;
import view.MenuView;

public class Main {

    public static void main(String[] args) {

        MenuView view = new MenuView();
        TicketController controller = new TicketController();

        boolean programmaAttivo = true;

        while (programmaAttivo) {

            int scelta = view.mostraMenuIniziale();

            switch (scelta) {

                case 1:
                    String nomeRegistrazione = InputUtility.leggiStringa("Inserisci username: ");
                    String passwordRegistrazione = InputUtility.leggiStringa("Inserisci password: ");

                    boolean registrato = controller.registraUtente(nomeRegistrazione, passwordRegistrazione);

                    if (registrato) {
                        view.stampaMessaggio("Registrazione completata con successo.");
                    } else {
                        view.stampaMessaggio("Username già esistente.");
                    }
                    break;

                case 2:
                    String nomeLogin = InputUtility.leggiStringa("Inserisci username: ");
                    String passwordLogin = InputUtility.leggiStringa("Inserisci password: ");

                    UtenteObserver utenteLoggato = controller.loginUtente(nomeLogin, passwordLogin);

                    if (utenteLoggato == null) {
                        view.stampaMessaggio("Credenziali non valide.");
                    } else {
                        view.stampaMessaggio("Login effettuato. Benvenuto " + utenteLoggato.getNomeUtente());

                        if (utenteLoggato.getRuolo().equalsIgnoreCase("ADMIN")) {
                            gestisciMenuAdmin(view, controller);
                        } else {
                            controller.registraUtenteObserver(utenteLoggato);
                            gestisciMenuUtente(view, controller, utenteLoggato);
                        }
                    }
                    break;

                case 0:
                    programmaAttivo = false;
                    view.stampaMessaggio("Programma terminato.");
                    break;

                default:
                    view.stampaMessaggio("Scelta non valida.");
                    break;
            }
        }
    }

    private static void gestisciMenuUtente(MenuView view, TicketController controller, UtenteObserver utente) {

        boolean menuAttivo = true;

        while (menuAttivo) {

            int scelta = view.mostraMenuUtente();

            switch (scelta) {

                case 1:
                    String titolo = InputUtility.leggiStringa("Inserisci titolo ticket: ");
                    String descrizione = InputUtility.leggiStringa("Inserisci descrizione ticket: ");

                    controller.creaTicket(titolo, descrizione, utente.getNomeUtente());

                    view.stampaMessaggio("Ticket creato con successo.");
                    break;

                case 2:
                    view.stampaTickets(controller.visualizzaTicketsUtente(utente.getNomeUtente()));
                    break;

                case 0:
                    menuAttivo = false;
                    view.stampaMessaggio("Logout effettuato.");
                    break;

                default:
                    view.stampaMessaggio("Scelta non valida.");
                    break;
            }
        }
    }

    private static void gestisciMenuAdmin(MenuView view, TicketController controller) {

        boolean menuAttivo = true;

        while (menuAttivo) {

            int scelta = view.mostraMenuAdmin();

            switch (scelta) {

                case 1:
                    view.stampaTickets(controller.visualizzaTuttiTickets());
                    break;

                case 2:
                    int idCompleto = InputUtility.leggiIntero("Inserisci ID ticket: ");
                    String nuovoTitolo = InputUtility.leggiStringa("Inserisci nuovo titolo: ");
                    String nuovaDescrizione = InputUtility.leggiStringa("Inserisci nuova descrizione: ");
                    String nuovoStato = InputUtility.leggiStringa("Inserisci nuovo stato: ");

                    boolean modificato = controller.modificaTicketCompleto(
                            idCompleto,
                            nuovoTitolo,
                            nuovaDescrizione,
                            nuovoStato
                    );

                    if (modificato) {
                        view.stampaMessaggio("Ticket modificato con successo.");
                    } else {
                        view.stampaMessaggio("Ticket non trovato.");
                    }
                    break;

                case 3:
                    int idCampo = InputUtility.leggiIntero("Inserisci ID ticket: ");
                    String campo = InputUtility.leggiStringa("Quale campo vuoi modificare? titolo/descrizione/stato: ");
                    String nuovoValore = InputUtility.leggiStringa("Inserisci nuovo valore: ");

                    boolean campoModificato = controller.modificaTicketSingoloCampo(
                            idCampo,
                            campo,
                            nuovoValore
                    );

                    if (campoModificato) {
                        view.stampaMessaggio("Campo modificato con successo.");
                    } else {
                        view.stampaMessaggio("Ticket non trovato o campo non valido.");
                    }
                    break;

                case 4:
                    int idElimina = InputUtility.leggiIntero("Inserisci ID ticket da eliminare: ");

                    boolean eliminato = controller.eliminaTicket(idElimina);

                    if (eliminato) {
                        view.stampaMessaggio("Ticket eliminato con successo.");
                    } else {
                        view.stampaMessaggio("Ticket non trovato.");
                    }
                    break;

                case 5:
                    int idRisolvi = InputUtility.leggiIntero("Inserisci ID ticket da risolvere: ");

                    boolean risolto = controller.risolviTicket(idRisolvi);

                    if (risolto) {
                        view.stampaMessaggio("Ticket risolto con successo.");
                    } else {
                        view.stampaMessaggio("Ticket non trovato.");
                    }
                    break;

                case 0:
                    menuAttivo = false;
                    view.stampaMessaggio("Logout admin effettuato.");
                    break;

                default:
                    view.stampaMessaggio("Scelta non valida.");
                    break;
            }
        }
    }
}