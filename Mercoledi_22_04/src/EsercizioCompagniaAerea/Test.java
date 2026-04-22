package EsercizioCompagniaAerea;

public class Test {
    public static void main(String[] args) {
        CompagniaAerea compagniaAerea = new CompagniaAerea("VoloExpress");

        //Creazione e aggiunta degli aerei alla compagnia
        compagniaAerea.aggiungiAereo( new Aereo("Boeing 737", -180, "A001"));
        compagniaAerea.aggiungiAereo(new Aereo("Airbus A320", 150, "A002"));
        compagniaAerea.aggiungiAereo(new Aereo("Boeing 777", 300, "A003"));

        //Creazione e aggiunta dei piloti alla compagnia
        compagniaAerea.aggiungiPilota(new Pilota("Mario Rossi", "BR123", 1200));
        compagniaAerea.aggiungiPilota( new Pilota("Luca Bianchi", "BR456", -800));
        compagniaAerea.aggiungiPilota( new Pilota("Anna Verdi", "BR789", 1500));


        //Stampo tutte le informazioni
        System.out.println("\n=== INFORMAZIONI COMPAGNIA ===");
        compagniaAerea.stampaInformazioni();
    }
}
