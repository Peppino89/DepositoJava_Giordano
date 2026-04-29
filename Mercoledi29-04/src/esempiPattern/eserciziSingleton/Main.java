package esempiPattern.eserciziSingleton;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.scriviMessaggio("Avvio del programma");
        logger2.scriviMessaggio("Operazione eseguita correttamente");


        System.out.println("=======Logger=======");
        System.out.println(logger1.toString());
        System.out.println(logger2.toString());
        System.out.println("==============");


        if (logger1.equals(logger2)) {
            System.out.println("È sempre la stessa istanza");
        } else {
            System.out.println("Sono istanze diverse");
        }

        System.out.println("========Utente======");
        Utente utente1 = Utente.getInstance();
        Utente utente2 = Utente.getInstance();

        utente1.scriviMessaggio("Salve a tutti");
        utente2.scriviMessaggio("Ciao Mondo");

        if (utente1.equals(utente2)) {
            System.out.println("È sempre la stessa istanza");
        }else {
            System.out.println("Sono istanze diverse");
        }


    }
}