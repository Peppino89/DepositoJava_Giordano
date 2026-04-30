package esercizi.esercizioDue;

// Interfaccia Observer
// Definisce il metodo di notifica per gli aggiornamenti delle azioni
public interface Investitore {

    // Metodo chiamato quando cambia il valore di un'azione
    public void notifica(String azione,double valore);
}