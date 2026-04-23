package esercizioAnimali;

import java.util.ArrayList;

public class Zoo {

    private ArrayList<Cane> cani;
    private ArrayList<Gatto> gatti;

    public Zoo() {
        this.cani = new ArrayList<>();
        this.gatti = new ArrayList<>();
    }

    public void aggiungiCane(Cane c) {
        this.cani.add(c);
    }

    public void aggiungiGatto(Gatto g) {
        this.gatti.add(g);
    }

    public ArrayList<Cane> getCani() {
        return this.cani;
    }

    public ArrayList<Gatto> getGatti() {
        return this.gatti;
    }

    public ArrayList<Animale> getTuttiGliAnimali() {

        ArrayList<Animale> animali = new ArrayList<>();
        animali.addAll(this.cani);
        animali.addAll(this.gatti);

        return animali;
    }



}
