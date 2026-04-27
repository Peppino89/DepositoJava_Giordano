package Esercizio;

import java.util.ArrayList;

// Classe Studente → eredita da Persona e implementa Registrabile
public class Studente extends Persona implements Registrabile {

    // Materia frequentata (specializzazione interna)
    private String classeFrequentata;

    // Lista dei voti dello studente
    private ArrayList<Integer> voti;

    // Costruttore
    public Studente(String nome, int eta, String classeFrequentata) {
        super(nome, eta); // chiamata al costruttore della classe padre
        this.classeFrequentata = classeFrequentata;
        this.voti = new ArrayList<>(); // inizializzazione lista voti
    }

    // Getter e setter
    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    public ArrayList<Integer> getVoti() {
        return voti;
    }

    // Metodo per aggiungere un voto alla lista
    public void aggiungiVoto(int voto) {
        this.voti.add(voto);
    }

    // Metodo per stampare i voti dello studente
    public void stampaVoti() {
        if (voti.size() > 0) {
            System.out.println("Stampo i voti di " + super.getNome() +
                    " materia " + this.getClasseFrequentata());

            // ciclo per stampare ogni voto
            for (Integer i : voti) {
                System.out.println(i);
            }
        } else {
            // caso in cui non ci sono voti
            System.out.println("Non ci sono voti");
        }
    }

    // Override del metodo astratto della classe Persona
    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe:  " + classeFrequentata);
    }

    // Implementazione del metodo dell'interfaccia Registrabile
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online");
    }
}