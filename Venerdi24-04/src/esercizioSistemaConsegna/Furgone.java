package esercizioSistemaConsegna;

/*
 * Furgone eredita da VeicoloConsegna.
 * Quindi è un veicolo di consegna.
 *
 * Implementa Tracciabile.
 * Quindi può essere tracciato.
 */
public class Furgone extends VeicoloConsegna implements Tracciabile {

    public Furgone(String targa, float caricoMassimo, float pesoPacco) {
        super(targa, caricoMassimo, pesoPacco);
    }

    /*
     * Metodo dell'interfaccia Tracciabile.
     */
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking furgone " + codiceTracking);
    }

    /*
     * POLIMORFISMO:
     * Furgone implementa consegnaPacco()
     * con una logica specifica: consegna via strada.
     */
    @Override
    void consegnaPacco(String destinazione) {

        /*
         * Controllo extra:
         * se il peso del pacco supera il carico massimo,
         * la consegna non può essere effettuata.
         */
        if (getPesoPacco() > getCaricoMassimo()) {
            System.out.println("ERRORE: il pacco pesa " + super.getPesoPacco() +
                    " kg, ma il carico massimo è " + super.getCaricoMassimo() + " kg.");
            return;
        }

        System.out.println("Il furgone con targa " + super.getTarga() +
                " sta consegnando via strada a " + destinazione);
    }
}