package EsercizioGestioneOfficina;

public class Auto {
    private String targa;
    private String modello;

    public Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "Targa: " + targa + ", Modello: " + modello;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Auto auto = (Auto) obj;

        return this.targa.equals(auto.targa) && this.modello.equals(auto.modello);
    }

    @Override
    public int hashCode() {

        int result = targa.hashCode();
        result = 31 * result + modello.hashCode();
        return result;
    }



}
