package sistema;

import java.util.Scanner;

public class EsempioCicloFor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um numero:");
        int numero = input.nextInt();

        System.out.println("Stampo la tabellina del: "+numero);

        for(int i=1; i<=10; i++){
            System.out.println(numero+" x "+i+" = "+(numero*i));
        }

        input.close();
    }
}
