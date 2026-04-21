package EsercizioGestioneOfficina;

import java.util.ArrayList;

public class Officina {

    ArrayList<Auto> officina;

    public Officina() {
        this.officina = new ArrayList<>();
    }

    public void stampaAuto() {
        for (Auto auto : officina) {
            System.out.println(auto);
        }
    }
    public void aggiungiAuto(Auto auto) {
        officina.add(auto);
    }

}
