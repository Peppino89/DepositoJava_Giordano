package esercizi.esercizioUno;

// Interfaccia Display (Observer)
// Definisce il metodo che verrà chiamato quando cambia la temperatura
public interface Display {

   // Metodo di aggiornamento che riceve la nuova temperatura
   public void aggiorna(float temperatura);
}