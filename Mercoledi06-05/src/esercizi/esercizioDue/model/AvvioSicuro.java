package esercizi.esercizioDue.model;


// Strategia di avvio sicuro
public class AvvioSicuro implements AvvioStrategy{

    @Override
    public void eseguiAvvio(Bios bios,HardDisk hardDisk,SistemaOperativo sistemaOperativo){

        System.out.println("Avvio in modalità sicura del computer...");

        // In modalità sicura vengono eseguite
        // meno operazioni rispetto all'avvio normale

        bios.inizializza();
        bios.carica();


        hardDisk.inizializza();
        hardDisk.carica();


        sistemaOperativo.inizializza();
        sistemaOperativo.carica();

    }
}
