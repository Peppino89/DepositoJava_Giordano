package esempiPattern.singleton;

public class Singleton {

    //Istanza privata statica della classe singleton
    private static Singleton instance;

    //Costruttore privato per impedire l'istanziazione diretta
    private Singleton() {}

    //Metodo pubblico per ottenere l'unica istanza della classe
    public static Singleton getInstance() {

        // se non esite l'istanza, viene creata
        if (instance == null) {
            instance = new Singleton();
        }

        //ritorna l'istanza creata o esitente
        return instance;
    }


    //Metodo di esempio che può essere chiamato sull'istanza Singleton
    public void doSomething() {
          System.out.println("Singleton: DoSomething() called");
    }
}
