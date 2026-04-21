package sistema;

import java.util.Objects;

public class Auto {
    String marca;
    String modello;
    int anno;
    double prezzo;

  //  public Auto() {}// costruttore vuoto

    public Auto() {
        marca = "Sconosciuto";
        modello = "Non definito";
        prezzo = 0.0;
    }

    // costruttore vuoto
    public  Auto(String marca, String modello, int anno, double prezzo) { //Costruttore con parametri
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    static int numeroRuote = 4;//è una varibile di classe e non dell'oggetto

    public static void camabiaNumeroRuote(int n) {
        numeroRuote += n;
    }

    public void mostraInfo() {
        System.out.println("Marca: " + marca
                + "\nModello: " + modello
                + "\nAnno: " + anno
                + "\nPrezzo: " + prezzo + " €\n");

    }



   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Auto other = (Auto) obj;
        return marca.equals(other.marca) && modello.equals(other.modello)&&anno == other.anno && prezzo == other.prezzo;
   }

   @Override
    public int hashCode() {
      //  return Objects.hash(marca, modello, anno, prezzo);
       int result = marca.hashCode();
       result = 31 * result + modello.hashCode();
       result = 31 * result + (int)prezzo;

       return result;
   }

   @Override
    public String toString() {
        return "Marca: " + marca+" Modello: "+modello+" Anno: "+anno+" Prezzo: "+prezzo;
   }
}
