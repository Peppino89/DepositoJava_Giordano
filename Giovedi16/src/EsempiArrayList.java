import java.util.ArrayList;

public class EsempiArrayList {

    public static void main(String[] args){

        //ArrayList è un array dinamico (a dimensione variabile ).
        // Fa parte del Java Collections Framework

        ArrayList<Integer> numeri = new ArrayList<Integer>();
        numeri.add(10);// metodo per aggiungere dei valori all'interno dell'arraylist
        numeri.add(20);
        numeri.add(30);

        ArrayList<String> nomi = new ArrayList<>();

        nomi.add("Alice");
        nomi.add("Bob");
        nomi.add("Carlo");

        System.out.println("Primo nome: "+nomi.get(0));//tramite il metodo get indico l'indice di posizione del quale voglio estrarre



    }

}