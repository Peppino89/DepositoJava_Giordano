package sistema;

public class Auto extends Veicolo {
    private String modello;

    public Auto(String modello) {
        this.modello = modello;
    }

    public void stampaInfo() {
        System.out.println("Modello: " + this.modello);
    }
}
