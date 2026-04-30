package esercizi.esercizioDue;

import java.util.ArrayList;

// Classe Subject (Observable)
// Gestisce gli investitori e notifica gli aggiornamenti delle azioni
public class AgenziaBorsa {

    // Lista degli observer (investitori registrati)
    private ArrayList<Investitore> investitori;

    // Costruttore: inizializza la lista
    public AgenziaBorsa() {
        this.investitori = new ArrayList<>();
    }

    // Metodo per aggiungere un investitore (registrazione observer)
    public void aggiungiInvestitore(Investitore investitore) {
        this.investitori.add(investitore);
    }

    // Metodo per rimuovere un investitore
    public void rimuoviInvestitore(Investitore investitore) {
        if( this.investitori.remove(investitore)){
            System.out.println("Investitore rimosso " );
        }else{
            System.out.println("Investitore non rimosso ");
        }

    }

    // Metodo che notifica tutti gli investitori
    public void notificaInvestitori(String azione,double valore) {
        for (Investitore i : this.investitori) {
            i.notifica(azione,valore);
        }
    }

    // Metodo che aggiorna il valore di un'azione
    // e notifica automaticamente tutti gli observer
    public void aggiornaValoreAzione(String nome,double valore) {
        System.out.println("\nAggiornamento azione: " + nome + " = " + valore + "€");
        notificaInvestitori(nome, valore);

    }
}