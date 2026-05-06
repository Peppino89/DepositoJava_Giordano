package esercizi.esercizioDue.model;


// Classe Facade
// Nasconde la complessità del sistema
// e fornisce un solo metodo semplice
// per accendere il computer
public class ComputerFacade {

    private Bios bios;
    private HardDisk hardDisk;
    private SistemaOperativo sistemaOperativo;

    // Strategia di avvio
    private AvvioStrategy avvioStrategy;



    public ComputerFacade(AvvioStrategy avvioStrategy) {

        this.avvioStrategy = avvioStrategy;
        this.sistemaOperativo = new SistemaOperativo();
        this.hardDisk = new HardDisk();
        this.bios = new Bios();
    }

    // Metodo Facade
    // Avvia il computer tramite la strategia scelta
    public void accendiComputer(){

       avvioStrategy.eseguiAvvio(bios,hardDisk,sistemaOperativo);

    }

    // Permette di cambiare strategia
    // durante l'esecuzione
    public void cambiaStrategia(AvvioStrategy avvioStrategy){
        this.avvioStrategy = avvioStrategy;
    }
}
