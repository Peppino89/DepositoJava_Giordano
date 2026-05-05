package Esercizio.model;

//Classe astratta per il Decoratore
public abstract class VeicoloDecorator implements Veicolo {

    protected Veicolo veicolo;

    public VeicoloDecorator(Veicolo veicolo) {
        this.veicolo = veicolo;
    }


    // Ho deciso di farlo astratto perchè ogni Decoratore potrà decidere come dovrà essere
    //implementato.
    public abstract String getDescription();
}
