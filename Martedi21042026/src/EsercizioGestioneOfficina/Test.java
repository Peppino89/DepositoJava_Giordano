package EsercizioGestioneOfficina;

public class Test {

    public static void main(String[] args) {
        Officina officina = new Officina();

        Auto a1 = new Auto("AB123CD", "Fiat Panda");
        Auto a2 = new Auto("EF456GH", "BMW X3");

        officina.aggiungiAuto(a1);
        officina.aggiungiAuto(a2);

        officina.stampaAuto();
    }
}
