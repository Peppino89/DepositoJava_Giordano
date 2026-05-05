package esempioMVC;

public class Main {
    public static void main(String[] args) {
        Studente model = new Studente("Mario Rossi",8);
        StudenteView view = new StudenteView();
        StudenteController controller = new StudenteController(model,view);

        controller.aggiornaView();
        System.out.println("--- Dopo aggiornamento ---");

        controller.setVotoStudente(20);
        controller.aggiornaView();
    }
}