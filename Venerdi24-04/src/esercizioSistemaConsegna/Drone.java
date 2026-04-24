package esercizioSistemaConsegna;

/*
 * Drone eredita da VeicoloConsegna.
 * Quindi condivide targa, caricoMassimo e pesoPacco.
 *
 * Implementa Tracciabile.
 * Quindi deve definire tracciaConsegna().
 */
public class Drone extends VeicoloConsegna implements Tracciabile {

    public Drone(String targa, float caricoMassimo, float pesoPacco) {
        super(targa, caricoMassimo, pesoPacco);
    }

    /*
     * Metodo richiesto dall'interfaccia Tracciabile.
     */
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking automatico drone: " + codiceTracking);
    }

    /*
     * POLIMORFISMO:
     * Drone consegna in modo diverso dal Furgone.
     */
    @Override
    void consegnaPacco(String destinazione) {

        /*
         * Controllo del carico massimo.
         */
        if (getPesoPacco() > getCaricoMassimo()) {
            System.out.println("ERRORE: il pacco pesa " + super.getPesoPacco() +
                    " kg, ma il carico massimo è " + super.getCaricoMassimo() + " kg.");
            return;
        }

        System.out.println("Il drone con codice " + super.getTarga() +
                " sta volando verso: " + destinazione);
    }
}