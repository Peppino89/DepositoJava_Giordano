package esercizioSistemaConsegna;

/*
 * INTERFACCIA:
 * Tracciabile rappresenta la capacità di essere tracciato.
 *
 * Non tutti gli oggetti devono per forza essere tracciabili,
 * ma Furgone e Drone in questo esercizio lo sono.
 */
public interface Tracciabile {

    /*
     * Metodo che tutte le classi tracciabili devono implementare.
     */
    void tracciaConsegna(String codiceTracking);
}