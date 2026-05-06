package esercizi.esercizioDue.controller;

import esercizi.esercizioDue.model.AvvioNormale;
import esercizi.esercizioDue.model.AvvioSicuro;
import esercizi.esercizioDue.model.ComputerFacade;
import esercizi.esercizioDue.view.ComputerView;


// Classe Controller
// Coordina Model e View
public class ComputerController {

    private ComputerView  computerView;

    public ComputerController(){
        this.computerView = new ComputerView();
    }


    // Metodo principale del programma
    public void start(){

        int scelta = 0;

        do {
            scelta = computerView.mostraMenu();

            switch (scelta) {
                case 1:
                    ComputerFacade computerNormale =
                            new ComputerFacade(new AvvioNormale());
                    computerNormale.accendiComputer();
                    break;

                case 2:
                    ComputerFacade computerSicuro =
                            new ComputerFacade(new AvvioSicuro());

                    computerSicuro.accendiComputer();
                    break;

                case 0:
                    computerView.mostraMessaggio("Programma terminato.");
                    break;

                default:
                    computerView.mostraMessaggio("Scelta non valida.");
            }

        } while (scelta != 0);

    }
}
