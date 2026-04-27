package Esercizio;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneScuola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Liste per salvare studenti e docenti
        ArrayList<Studente> studenti = new ArrayList<>();
        ArrayList<Docente> docenti = new ArrayList<>();

        int scelta;

        // Ciclo del menu (continua finché non si sceglie 5)
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crea studente");
            System.out.println("2. Crea docente");
            System.out.println("3. Visualizza studenti di un docente");
            System.out.println("4. Aggiungi voto");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            scelta = input.nextInt();
            input.nextLine(); // pulizia buffer

            switch (scelta) {

                // CREAZIONE STUDENTE
                case 1:
                    System.out.print("Nome studente: ");
                    String nomeStudente = input.nextLine();

                    System.out.print("Età studente: ");
                    int etaStudente = input.nextInt();
                    input.nextLine();

                    System.out.print("Materia frequentata: ");
                    String materiaStudente = input.nextLine();

                    // Creazione oggetto Studente
                    Studente s = new Studente(nomeStudente, etaStudente, materiaStudente);
                    studenti.add(s); // aggiunta alla lista

                    System.out.println("Studente creato.");
                    break;

                // CREAZIONE DOCENTE
                case 2:
                    System.out.print("Nome docente: ");
                    String nomeDocente = input.nextLine();

                    System.out.print("Età docente: ");
                    int etaDocente = input.nextInt();
                    input.nextLine();

                    System.out.print("Materia insegnata: ");
                    String materiaDocente = input.nextLine();

                    // Creazione oggetto Docente
                    Docente d = new Docente(nomeDocente, etaDocente, materiaDocente);
                    docenti.add(d);

                    System.out.println("Docente creato.");
                    break;

                // VISUALIZZAZIONE STUDENTI DI UNA MATERIA
                case 3:
                    // Controllo se ci sono docenti
                    if (docenti.isEmpty()) {
                        System.out.println("Nessun docente presente.");
                        break;
                    }

                    // Scelta docente
                    System.out.println("Scegli docente:");
                    for (int i = 0; i < docenti.size(); i++) {
                        System.out.println(i + " - " + docenti.get(i).getNome()
                                + " (" + docenti.get(i).getMateria() + ")");
                    }

                    int sceltaDocente = input.nextInt();
                    input.nextLine();

                    Docente docenteScelto = docenti.get(sceltaDocente);

                    System.out.println("Studenti della materia " + docenteScelto.getMateria() + ":");

                    // Mostra solo studenti della stessa materia del docente
                    for (Studente studente : studenti) {
                        if (studente.getClasseFrequentata()
                                .equalsIgnoreCase(docenteScelto.getMateria())) {

                            System.out.println("- " + studente.getNome());
                            studente.stampaVoti(); // stampa voti
                        }
                    }
                    break;

                // AGGIUNTA VOTO
                case 4:
                    // Controllo che esistano studenti e docenti
                    if (docenti.isEmpty() || studenti.isEmpty()) {
                        System.out.println("Devi prima creare almeno un docente e uno studente.");
                        break;
                    }

                    // Scelta docente
                    System.out.println("Scegli docente:");
                    for (int i = 0; i < docenti.size(); i++) {
                        System.out.println(i + " - " + docenti.get(i).getNome()
                                + " (" + docenti.get(i).getMateria() + ")");
                    }

                    int indiceDocente = input.nextInt();
                    input.nextLine();

                    Docente docente = docenti.get(indiceDocente);

                    System.out.println("Studenti disponibili per la materia " + docente.getMateria() + ":");

                    // Lista temporanea degli studenti della stessa materia
                    ArrayList<Studente> studentiMateria = new ArrayList<>();

                    // Filtro studenti per materia
                    for (Studente studente : studenti) {
                        if (studente.getClasseFrequentata()
                                .equalsIgnoreCase(docente.getMateria())) {

                            studentiMateria.add(studente);
                        }
                    }

                    // SE NON CI SONO STUDENTI → entra qui
                    if (studentiMateria.isEmpty()) {
                        System.out.println("Nessuno studente frequenta questa materia.");
                        break;
                    }

                    // Mostra studenti disponibili
                    for (int i = 0; i < studentiMateria.size(); i++) {
                        System.out.println(i + " - " + studentiMateria.get(i).getNome());
                    }

                    System.out.print("Scegli studente: ");
                    int indiceStudente = input.nextInt();

                    System.out.print("Inserisci voto: ");
                    int voto = input.nextInt();
                    input.nextLine();

                    // Prende lo studente scelto dalla lista filtrata
                    Studente studente = studentiMateria.get(indiceStudente);

                    // Il docente assegna il voto
                    docente.assegnaVoto(studente, voto);

                    System.out.println("Voto aggiunto correttamente.");
                    break;

                case 5:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 5);

        input.close();
    }
}