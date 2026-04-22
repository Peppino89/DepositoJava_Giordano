package EsercizioCompagniaAerea;

import java.util.ArrayList;

public class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    public CompagniaAerea(String nome){
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    public void aggiungiPilota(Pilota p){

        this.piloti.add(p);
    }

    public void aggiungiAereo(Aereo aereo){
        this.flotta.add(aereo);
    }

    public void stampaInformazioni(){
        for(Aereo aereo : this.flotta){
            System.out.println(aereo.toString());
        }

        System.out.println();

        for(Pilota pilota : this.piloti){
            System.out.println(pilota.toString());
        }
    }


}
