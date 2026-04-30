package esercizi.esercizioUno;

// Classe principale per testare il sistema Observer
public class Main {

    public static void main(String[] args) {

        // Creazione del Subject (stazione meteo)
        StazioneMeteo stazione = new StazioneMeteo();

        // Creazione degli observer (display)
        Display console = new DisplayConsole();
        Display mobile = new DisplayMobile();
        Display Auto = new Smartophone();

        Display Smartophone = new Smartophone();
        Display Monitor = new Monitor();

        // Registrazione dei display alla stazione meteo
        stazione.aggiungiDisplay(console);
        stazione.aggiungiDisplay(mobile);
        stazione.aggiungiDisplay(Auto);
        stazione.aggiungiDisplay(Smartophone);
        stazione.aggiungiDisplay(Monitor);

        // Cambio temperatura → notifica automatica a tutti i display
        stazione.setTemperatura(22.5f);
        stazione.setTemperatura(25.0f);
        stazione.setTemperatura(35.0f);

        // Rimozione di un display
        stazione.rimuoviDisplay(console);

        // Nuova temperatura → il display rimosso non riceve più aggiornamenti
        stazione.setTemperatura(18.7f);
    }
}