package sistema;

import java.util.Scanner;

public class EsercizioFor {
    public static void main(String[] args) {

         Scanner input = new Scanner(System.in);
         System.out.println("Quanti voti vuoi inserire: ");// chiedo all'utente quanti voti vuol inserire
         int numVoti = input.nextInt();// contiene la risposta input dellutente
         int votiValidi=0;// contatore dei numeri valiti

         while(numVoti<=0){ // nel caso in cui l'utente non inserisce un numero valido gli viene chiesto di nuovo il numero di voti
             System.out.println("Inserisci un numero positivo interno: ");
             numVoti = input.nextInt();

         }

         for(int i=1; i<=numVoti; i++){// una volta ottenuto il numero dei voti l'utente inserisce i voti
             System.out.println("inserisci il voto: ");
             int voto = input.nextInt();

             if(voto >= 0 && voto <=30){ // condizione per verificare che il voto sia compreso tra (0 e 31)estremi inclusi
                 votiValidi++;// se il voto è valido incremento il contatore
                 if(voto>=18 && voto < 24){ // se il voto è maggiore uguale a 18 e minore di 24
                     System.out.println("Sufficente ");// stampa sufficente
                 }else if(voto>=24){// se il voto è maggiore uguale di 24
                     System.out.println("Buono o Ottimo "); // stampa ottimo o buono
                 }else{
                     System.out.println("Insufficiente ");//altrimenti Insufficente
                 }

             }else{
                 System.out.println("voto no valido");// se il voto non rientra nel range allora stampa fuori range
             }

         }
         System.out.println("Voti validi inseriti: "+votiValidi);

         input.close();


    }
}
