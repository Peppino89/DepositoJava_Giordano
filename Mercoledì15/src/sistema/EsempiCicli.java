package sistema;

import java.util.Scanner;

public class EsempiCicli {
    public static void main(String[] args){

        // Il Ciclo While valuta la condizione prima di entrare nel ciclo, se la condizione è vera

        int x = 1;
        while(x<=5){
            x++;

        }System.out.println(x);

        //Ciclo Do While entra almeno una volta nel ciclo


        Scanner input = new Scanner(System.in);

        int numero;

        do{
            System.out.print("Inserisci un numero (0 per uscire): ");
            numero = input.nextInt();

        }while(numero!=0);

        System.out.println("Ok sei uscito");
    }
}
