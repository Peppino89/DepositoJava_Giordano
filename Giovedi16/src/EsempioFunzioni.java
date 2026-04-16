public class EsempioFunzioni {
    public static void main(String[] args) {

        saluta();
        mostra(10);
        mostra("Pippo");

    }

    //Dichiarazione di un metodo senza parametri e senza valore di ritorno
    public static void saluta(){
        System.out.println("Ciao");
    }


    //Dichiarazione di un metodo con parametri e con valore di ritorno
    public static int somma(int a, int b){
        return a+b;
    }

    //overloading dei metodi ovvero metodi con lo stesso nome ma con parametri diversi
    public static void mostra(int numero){
        System.out.println(numero);
    }

    public static void mostra(String testo){
        System.out.println(testo);
    }

}
