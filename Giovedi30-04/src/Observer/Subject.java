package Observer;

// Interfaccia Subject
// Definisce i metodi per gestire gli observer
public interface Subject {

    // Aggiunge un observer (iscrizione alle notifiche)
    void registerObserver(Observer o);

    // Rimuove un observer (cancellazione dalle notifiche)
    void removeObserver(Observer o);

    // Notifica tutti gli observer
    void notifyObservers();
}