import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Liste utenti
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();

        //Storico di ogni utente
        ArrayList<ArrayList<String>> storicoValoriPerUtente = new ArrayList<>();
        ArrayList<ArrayList<String>> storicoOperazioniPerUtente = new ArrayList<>();
        ArrayList<ArrayList<Double>> storicoRisultatiPerUtente = new ArrayList<>();

        boolean iniziaProgramma = true;
        1
        while (iniziaProgramma) {
            System.out.println("\n====== Menu =======");
            System.out.println("1. Registrazione");
            System.out.println("2. Login");
            System.out.println("3. Esci ");
            int scelta = input.nextInt();
            switch (scelta) {

                case 1:
                    registrazione(input, usernames, passwords, storicoValoriPerUtente, storicoOperazioniPerUtente, storicoRisultatiPerUtente);
                    break;

                case 2: int indiceUtente = login(input, usernames, passwords);
                                    if (indiceUtente != -1) {
                                            menuUtente(input, indiceUtente, usernames,
                                                storicoValoriPerUtente,
                                                storicoOperazioniPerUtente,
                                                storicoRisultatiPerUtente);
                                    }
                    break;



                case 3:
                    iniziaProgramma = false;
                    System.out.println("Programma Terminato");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }
        }
        input.close();
    }

    // metodo per la registrazione dell'utente
    public static void registrazione(Scanner input,
                                     ArrayList<String> usernames,
                                     ArrayList<String> passwords,
                                     ArrayList<ArrayList<String>> StoricoValoriPerUtente,
                                     ArrayList<ArrayList<String>> StoricoOperazioniPerUtente,
                                     ArrayList<ArrayList<Double>> StoricoRisultatiPerUtente) {

        input.nextLine();//mi serve per pulire il buffer della riga
        System.out.print("Inserisci Username: ");
        String username = input.nextLine();

        if (utenteEsistente(usernames, username)) {
            System.out.print("Utente già registrato");
            return; //esci dal programma
        } else {

            // se l'utente non è registrato
            System.out.print("Inserisci Password: ");
            String password = input.nextLine();

            //Creo l'utente
            usernames.add(username);
            passwords.add(password);

            //e creo e memorizzo i suoi storici
            StoricoValoriPerUtente.add(new ArrayList<String>());
            StoricoRisultatiPerUtente.add(new ArrayList<Double>());
            StoricoOperazioniPerUtente.add(new ArrayList<String>());

            System.out.print("Registrazione Completata con Successo! ");

        }

    }

    //metodo che mi serve per verificare se un'utente è registrato o meno
    public static boolean utenteEsistente(ArrayList<String> usernames, String nomeUtente) {

        for (String username : usernames) {
            if (username.equals(nomeUtente)) {
                return true;
            }
        }
        return false;

    }

    //metodo per gestire la fase di login
    public static int login(Scanner input, ArrayList<String> usernames, ArrayList<String> passwords) {
        input.nextLine();// pulisco il buffer della riga
        System.out.print("Inserisci Username: ");
        String username = input.nextLine();

        System.out.print("Inserisci Password: ");
        String password = input.nextLine();

        for (int i = 0; i < usernames.size(); i++) {
            if (username.equals(usernames.get(i)) &&
                    password.equals(passwords.get(i))) {
                System.out.println("Login Effettuato");
                return i; //faccio ritornare l'indice dell' utente che mi servirà poi nel menu
            }
        }
        System.out.println("Credenziali Errate ! ");
        return -1;

    }

    //in questa funzione si attiva il menu Principale dell'utente
    public static void menuUtente(Scanner input,
                                      int indiceUtente,
                                      ArrayList<String> usernames,
                                      ArrayList<ArrayList<String>> storicoValoriPerUtente,
                                      ArrayList<ArrayList<String>>storicoOperazioniPerUtente,
                                      ArrayList<ArrayList<Double>> storicoRisultatiPerUtente) {

        int contatoreOperzioni = 0 ;
        boolean loggato=true;

        while (loggato){
            System.out.println("\n====== Menu Utente=======");
            System.out.println("Benvenuto utente: "+usernames.get(indiceUtente));
            System.out.println("Hai a tua disposizione "+(4-contatoreOperzioni)+" operazioni");
            System.out.println("Digita: ");
            System.out.println("1. Calcolatrice");
            System.out.println("2. Storico");
            System.out.println("3. Logout");

            int  scelta = input.nextInt();
            switch (scelta) {
                case 1:boolean ok =
            }
        }



    }

    public static boolean usaCalcolatrice(Scanner input,
                                          int indiceUtente,
                                          ArrayList<ArrayList<String>>storicoValoriPerUtente,
                                          ArrayList<ArrayList<String>>storicoOperazioniPerUtente,
                                          ArrayList<ArrayList<Double>>storicoRisultatiPerUtente) {

        System.out.print("Quanti numeri sono ?: ");
        int n =  input.nextInt();

        if (n<2) {
            return false;
        }else{
            ArrayList<Double>numeri = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.print("Inserisci numero: "+(i+1)+": ");
                numeri.add(input.nextDouble());
            }

            System.out.println("Inserisci Operazioni: ");
            System.out.println("1 Somma");
            System.out.println("2 Sottrazione");
            System.out.println("3 Moltiplicazione");
            System.out.println("4 Divisione");
            System.out.println("5 Media");

            int typeOperazione = input.nextInt();

            double risultato = 0.0;
            String nomeOperazione = "";

            switch (typeOperazione) {
                case 1:
                  risultato = sommaNumeri(numeri);
                  nomeOperazione = "Somma";
                  break;

                case 2: risultato = sottrazione(numeri);
                nomeOperazione = "Sottrazione";
                break;

                case 3: risultato = moltiplicazione(numeri);
                nomeOperazione = "Moltiplicazione";
                break;

                case 4: risultato = divisione(numeri);
                nomeOperazione = "Divisione";
                break;

                case 5: risultato = media(numeri);
                nomeOperazione = "Media";
                break;

                default: System.out.println("Operazione non valida");
                return false;
            }

            String valori = "";

            for (int i = 0; i < numeri.size(); i++) {
                valori += numeri.get(i) + " ";
            }

            storicoValoriPerUtente.get(indiceUtente).add(valori);
            storicoOperazioniPerUtente.get(indiceUtente).add(nomeOperazione);
            storicoRisultatiPerUtente.get(indiceUtente).add(risultato);

            System.out.print("Risultato: "+risultato);
            return true;

        }

    }

    public static double sommaNumeri(ArrayList<Double> numeri) {
        double somma = 0;
        for (Double numero : numeri) {
            somma = somma + numero;
        }
        return somma;
    }

    public static double sottrazione(ArrayList<Double> numeri) {
        double sottrazione = numeri.get(0);
        for (int i = 1; i < numeri.size(); i++) {
            sottrazione -= numeri.get(i);
        }
        return sottrazione;
    }

    public static double moltiplicazione(ArrayList<Double> numeri) {
        double molt=1;

        for (Double numero : numeri) {
            molt *=numero;
        }
        return molt;
    }

    public static double divisione(ArrayList<Double> numeri) {
        double divisione=numeri.get(0);

        for (int i = 1; i < numeri.size(); i++) {
            divisione /=numeri.get(i);
        }

        return divisione;
    }

    public static double media(ArrayList<Double> numeri) {
        return sommaNumeri(numeri)/numeri.size();
    }

    public static void mostraStorico(int indiceUtente,
                                     ArrayList<ArrayList<String>>storicoValoriPerUtente,
                                     ArrayList<ArrayList<String>>storicoOperazioniPerUtente,
                                     ArrayList<ArrayList<Double>>storicoRisultatiPerUtente) {

        if(storicoValoriPerUtente.size()==0){
            System.out.println("nessuno Storico al momento: ");

            return;//esci dal programma
        }

      for()
    }




}