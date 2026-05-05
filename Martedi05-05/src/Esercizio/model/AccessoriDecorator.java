package Esercizio.model;

// Decoratore concreto per aggiungere accessori
public class AccessoriDecorator extends VeicoloDecorator {

    private String accessori;

    public AccessoriDecorator(Veicolo veicolo, String accessori) {
        super(veicolo);
        this.accessori = accessori;
    }


    @Override
    public String getDescription() {
        return veicolo.getDescription()+" con "+accessori ;
    }
}
