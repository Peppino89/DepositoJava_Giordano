package Esercizio;

// Classe Docente → eredita da Persona e implementa Registrabile
public class Docente extends Persona implements Registrabile {

    // Materia insegnata dal docente
    private String materia;

    // Costruttore
    public Docente(String nome,int eta, String materia) {
        super(nome, eta); // chiamata al costruttore della classe padre
        this.materia = materia;
    }

    // Metodo per assegnare un voto a uno studente
    public void assegnaVoto(Studente studente, int voto) {
        studente.aggiungiVoto(voto); // aggiunge il voto allo studente

        // stampa conferma
        System.out.println("Il docente " + getNome() +
                " ha assegnato il voto " + voto +
                " allo studente " + studente.getNome());
    }

    // Getter e setter
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    // Implementazione del metodo dell'interfaccia Registrabile
    @Override
    public void registrazione() {
        System.out.println("Registrazione avvenuta tramite segreteria didattica");
    }

    // Override del metodo astratto della classe Persona
    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di: " + materia);
    }
}