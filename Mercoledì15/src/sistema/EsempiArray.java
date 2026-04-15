package sistema;

public class EsempiArray {
    public static void main(String[] args) {

        //Dichiarazione e inizializzazione dell'array

        int[] numeri = new int[5];//array di dimensioni 5

        int [] valori = {1,2,3,4,5}; //inizializzazione diretta


        //for-each di array

        int[] num_a = {1,2,3};

        for(int i:num_a) {
            System.out.println(i);

            // c'è il -1 perchè deve rispettare il modo in cui conta l'array
            System.out.println(num_a[i-1]);
        }

    }
}
