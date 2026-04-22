package EsercizioCompagniaAerea;

public class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        this.setNumeroPosti(numeroPosti);
        this.codice = codice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti >0) {
            this.numeroPosti = numeroPosti;
        }else{
            System.out.println("Errore numero posti "+numeroPosti+" non è valido inserisci un numero positivo");
        }
    }

    public String getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return "Aereo { " + "Modello: "+this.getModello()+" NumeroPosti: "+this.getNumeroPosti()+" Codice: "+this.getCodice() + "}";
    }


}
