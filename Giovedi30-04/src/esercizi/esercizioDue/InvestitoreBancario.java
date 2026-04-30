package esercizi.esercizioDue;

// Observer concreto
// Rappresenta una banca che riceve aggiornamenti
public class InvestitoreBancario implements Investitore {

    private String banca;

    // Costruttore
    public InvestitoreBancario(String banca) {
        this.banca = banca;
    }

    // Metodo chiamato quando arriva una notifica
    @Override
    public void notifica(String azione,double valore) {
        System.out.println("Banca " + banca +
                ": aggiorniamo il portafoglio clienti. Azione " +
                azione + " ora vale " + valore + "€");
    }
}