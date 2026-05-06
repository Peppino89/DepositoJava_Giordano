package esercizi.esercizioDue.model;


// Strategia di avvio normale
public class AvvioNormale implements AvvioStrategy {

    @Override
    public void eseguiAvvio(Bios bios,HardDisk hardDisk,SistemaOperativo sistemaOperativo){

        System.out.println("Avvio normale del computer...");

        // Sequenza di avvio BIOS
        bios.inizializza();
        bios.carica();
        bios.avvia();

        // Sequenza di avvio Hard Disk
        hardDisk.inizializza();
        hardDisk.carica();
        hardDisk.avvia();


        // Sequenza di avvio Sistema Operativo
        sistemaOperativo.inizializza();
        sistemaOperativo.carica();
        sistemaOperativo.avvia();
    }


}
