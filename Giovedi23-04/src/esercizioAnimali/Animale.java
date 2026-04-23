package esercizioAnimali;

public class Animale {
    protected String nome;
    protected int eta;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void faiVerso(){
        System.out.println("Verso generico....");
    }

    public String getNome() {
        return this.nome;
    }

    public int getEta() {
        return this.eta;
    }

}
