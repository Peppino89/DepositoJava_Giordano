package esercizioStudnete;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        // Creazione studente
        Studente s1 = new Studente("Mario", 8);

        // Stampa iniziale
        System.out.println(s1);

        // Modifiche voto
        s1.setVoto(9);   // caso valido
        System.out.println("Dopo modifica valida: " + s1);

        s1.setVoto(15);  //caso  non valido
        System.out.println("Dopo modifica NON valida: " + s1);

        // Lista studenti
        ArrayList<Studente> lista = new ArrayList<>();

        lista.add(s1);
        lista.add(new Studente("Luca", 7));
        lista.add(new Studente("Anna", 10));

        // Stampa lista
        System.out.println("\nLista studenti:");
        for (Studente s : lista) {
            System.out.println(s);
        }

        // Ricerca per nome
        String nomeDaCercare = "Paolo";
        System.out.println("\nRicerca studente con nome: " + nomeDaCercare);

        boolean trovato = false;
        for (Studente s : lista) {
            if (s.getNome().equalsIgnoreCase(nomeDaCercare)) {
                System.out.println("Trovato: " + s);
                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Studente non trovato.");
        }
    }
}
