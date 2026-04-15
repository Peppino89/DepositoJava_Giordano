package sistema;

public class EsempiArrayMultidimensionali {
    public static void main(String []args) {

        //Array 2D
        int[][] matrice = new int[3][3];

        //Inizializzazione diretta

        int[][] matricePredefinita = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("elmento centrale: "+matricePredefinita[1][1]);
    }
}
