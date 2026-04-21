package sistema;

public class Libro {

     String titolo;
     String autore;
    double prezzo;
    static int codice_numerico_autoincrementante;

    public Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        codice_numerico_autoincrementante++;
    }

    public void mostraDettagli(){
        System.out.println("Titolo: "+titolo+" Autore: "+autore+" Prezzo: "+prezzo+" €");

    }



}
