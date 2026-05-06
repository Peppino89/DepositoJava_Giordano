package esercizi.esercizioDue.view;

import java.util.Scanner;


// Classe View
// Gestisce input e output
public class ComputerView {

    private Scanner scanner;

    public ComputerView(){
        this.scanner = new Scanner(System.in);
    }

    public int mostraMenu() {
        System.out.println();
        System.out.println("===== MENU COMPUTER =====");
        System.out.println("1. Avvio normale");
        System.out.println("2. Avvio sicuro");
        System.out.println("0. Esci");
        System.out.print("Scegli un'opzione: ");

        return scanner.nextInt();
    }

    public void mostraMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
}
