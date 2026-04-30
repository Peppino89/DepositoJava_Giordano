package esercizi.esercizioUno;

import java.util.ArrayList;

// Classe Subject (Observable)
// Gestisce la temperatura e notifica tutti i display registrati
public class StazioneMeteo {

    // Stato: temperatura corrente
    private float temperatura;

    // Lista degli observer (display registrati)
    private ArrayList<Display> displayRegistrati;


    public StazioneMeteo() {
        this.displayRegistrati = new ArrayList<>();
    }

    // Metodo per impostare una nuova temperatura
    // Quando cambia, notifica tutti i display
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notifica();
    }

    // Metodo per aggiungere un display (registrazione observer)
    public void aggiungiDisplay(Display display) {
        this.displayRegistrati.add(display);
    }

    // Metodo per rimuovere un display (cancellazione observer)
    public void rimuoviDisplay(Display display) {
        this.displayRegistrati.remove(display);
    }

    // Metodo che notifica tutti i display registrati
    public void notifica() {
        // Scorre tutti i display e li aggiorna con la nuova temperatura
        for (Display displayRegistrati : this.displayRegistrati) {
            displayRegistrati.aggiorna(temperatura);
        }
    }
}