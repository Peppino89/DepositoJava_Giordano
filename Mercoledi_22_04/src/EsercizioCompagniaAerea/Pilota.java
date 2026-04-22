package EsercizioCompagniaAerea;

public class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.setOreVolo(oreVolo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        if(oreVolo >=0){
            this.oreVolo = oreVolo;
        }else{
            System.out.println("Errore Ore di Volo "+ oreVolo+" non è valido inserire un numero positivo ");
        }
    }

    @Override
    public String toString() {
        return "Pilota {" + "Nome: " + this.getNome() + "Numero Brevetto: " + this.getNumeroBrevetto() + " Ore di volo: " + this.getOreVolo() + '}';
    }
}
