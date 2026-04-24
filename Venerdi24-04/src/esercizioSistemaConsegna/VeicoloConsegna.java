package esercizioSistemaConsegna;

/*
 * CLASSE ASTRATTA:
 * VeicoloConsegna rappresenta un veicolo generico per le consegne.
 * Non creo direttamente un VeicoloConsegna,
 * ma creo veicoli specifici come Furgone o Drone.
 */
abstract class VeicoloConsegna {

    /*
     * INCAPSULAMENTO:
     * Gli attributi sono private e vengono gestiti con getter/setter.
     */
    private String targa;
    private float caricoMassimo;
    private float pesoPacco;

    public VeicoloConsegna(String targa, float caricoMassimo, float pesoPacco) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
        this.pesoPacco = pesoPacco;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public float getCaricoMassimo() {
        return caricoMassimo;
    }

    public void setCaricoMassimo(float caricoMassimo) {
        this.caricoMassimo = caricoMassimo;
    }

    public float getPesoPacco() {
        return pesoPacco;
    }

    public void setPesoPacco(float pesoPacco) {
        this.pesoPacco = pesoPacco;
    }

    /*
     * METODO ASTRATTO:
     * Ogni veicolo consegna in modo diverso.
     * Furgone consegna via strada, Drone via aria.
     */
    abstract void consegnaPacco(String destinazione);

    /*
     * Metodo concreto comune a tutti i veicoli.
     */
    public void stampaInfo() {
        System.out.println("Targa: " + targa +
                " caricoMassimo: " + caricoMassimo +
                " pesoPacco: " + pesoPacco);
    }
}