package EsempioEreditarieta;

public class Studente extends Persona {
    private String scuola;
    public Studente( String nome,String scuola) {
        super(nome);
        this.scuola = scuola;
    }

    @Override
    public void saluta(){
        super.saluta();
        System.out.println("e vado alla scuola: " + this.scuola);

    }
}
