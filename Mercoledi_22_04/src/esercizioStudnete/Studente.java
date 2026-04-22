package esercizioStudnete;

public class Studente {
    private String nome;
    private int voto;
    private static int idCount = 0;
    private int id;

    public Studente(String nome, int voto){
        this.nome = nome;
        this.setVoto(voto);
        idCount++;
        this.id = idCount;
    }

    public String getNome(){
        return this.nome;
    }

    public int getVoto(){
        return this.voto;
    }

    public void setVoto(int voto){
        if(voto>=0 && voto<=10){
          this.voto = voto;
        }else{
            System.out.println("Errore: Il voto deve essere entre 0 e 10");
        }
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "ID: " + getId()+ " Nome: " + getNome() + " Voto: " + getVoto();
    }
}
