package esercizi.esercizioDue.model;

// Interfaccia Strategy
// Definisce il comportamento comune
// delle varie modalità di avvio
public interface AvvioStrategy {
    void eseguiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo sistemaOperativo);
}
