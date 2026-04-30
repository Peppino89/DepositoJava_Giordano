package esercizi.esercizioTre;

import java.util.Observable;

// Interfaccia Observer
// Definisce il metodo che viene chiamato quando arriva una notifica
public interface Observer {

    // Metodo di aggiornamento
    void update(String messagge);
}