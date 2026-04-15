package sistema;

import java.util.Scanner;

public class EsercizioWhile {

    public static void main(String[] args) {

        int numTentativi = 0;
        boolean isAutenticato = false;
        String risposta;
        Scanner input = new Scanner(System.in);

        while(numTentativi < 3 && !isAutenticato) {
            System.out.print("Inserisci la password: ");
            String password = input.nextLine();
            if(password.equals("java123")) {
                isAutenticato = true;
            }

            numTentativi++;
        }

        if(!isAutenticato) {
            System.out.println("Hai superato il numero di tentivi");
        }else{
            System.out.println("Sei autenticato");

            do{
                System.out.print("vuoi accedere al sistema (s/n): ");
                risposta = input.nextLine();
                System.out.println("Perfetto sei dentro al sistema ");
            }while(risposta.equals("s"));

            isAutenticato = false;
            System.out.println("Sei uscito dal sistema ");

        }

             input.close();
    }
}
