package Observer;

// Classe concreta che implementa l'interfaccia Observer
// Rappresenta un utente che riceve le notifiche
public class ConcreteObserver implements Observer {

    private String nome;

    public ConcreteObserver(String nome) {
        this.nome = nome;
    }

    // Metodo chiamato quando il Subject invia una notifica
    @Override
    public void update(String message) {
        System.out.println(this.nome + ": " + message);
    }
}
