package esercizioAnimali;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Zoo zoo = new Zoo();
        System.out.println("===== Menu ===== ");
         boolean start = true;

        while (start) {
            System.out.println("Digita 1 per inserire Cane");
            System.out.println("Digita 2 per inserire Gatto");
            System.out.println("Digita 3 per Uscire");

            int risposta = input.nextInt();

            switch (risposta) {
                case 1:
                    gestioneCane(input,zoo);
                    break;
                case 2: gestioneGatto(input,zoo);
                        break;
                case 3:  start = false;
                         System.out.println("Sei uscito dal programma");
                            break;
                default: System.out.println("Risposta non valido");
                         break;

            }

        }

        if(!zoo.getCani().isEmpty() || !zoo.getGatti().isEmpty()) {
            System.out.println("======Stampo i risultati======\n");

            for (int i = 0; i < zoo.getTuttiGliAnimali().size(); i++) {
                System.out.println("Nome: " + zoo.getTuttiGliAnimali().get(i).getNome() + " Età: "
                        + zoo.getTuttiGliAnimali().get(i).getEta()+" Verso:");
                    zoo.getTuttiGliAnimali().get(i).faiVerso();

                    System.out.println();

            }
        }else{
            System.out.println("Non Hai inserito nessun Animale. ");
        }
    }

    public static void gestioneCane(Scanner input, Zoo zoo) {
              input.nextLine();

              System.out.println("Quanti cani vuoi inserire ");
              int numCani = input.nextInt();

              input.nextLine();
              for (int i=0; i<numCani; i++) {
                  System.out.println("Cane numero: "+(i+1));
                  System.out.println("Inserisci nome Cane");
                  String nomeCane = input.nextLine();

                  System.out.println("Inserisci età del cane: ");
                  int etaCane = input.nextInt();

                  input.nextLine();

                  System.out.println();
                  zoo.getCani().add(new Cane(nomeCane, etaCane));
              }



    }

    public static void gestioneGatto(Scanner input, Zoo zoo) {

        input.nextLine();

        System.out.println("Quanti gatti vuoi inserire ");
        int numGatti = input.nextInt();

        input.nextLine();
        for (int i=0; i<numGatti; i++) {
            System.out.println("Gatto numero: "+(i+1));
            System.out.println("Inserisci nome Gatto");
            String nomeGatto = input.nextLine();

            System.out.println("Inserisci età del gatto: ");
            int etaGatto = input.nextInt();

            input.nextLine();

            System.out.println();

            zoo.getGatti().add(new Gatto(nomeGatto, etaGatto));
        }
    }
}
