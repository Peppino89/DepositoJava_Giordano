public class EsercizioMetodi {

    public static void main(String[] args) {

        // Test dei metodi fattoriale (iterativo e ricorsivo)
        System.out.println(fattoriale(4));
        fattoriale("Ciao"); // Overload: gestisce input non valido
        System.out.println(fattorialeRicorsivo(0));

        // Test metodi matematici base
        System.out.println("Somma di due numeri: " + somma(4,6));
        System.out.println("Moltiplicazione di due numeri: " + multply(4,5));
        System.out.println("Moltiplicazione di tre numeri: " + multply(3,4,5));
        System.out.println("Somma dei numeri naturali: " + sommaNaturali(3));

        // Variabile primitiva e array per mostrare la differenza di comportamento
        int x = 20;
        int[] a = {1,2,3};

        System.out.println("Prima della modifica");
        System.out.println("Valore x: " + x);
        System.out.println("Primo valore dell'array: " + a[0]);

        // Passaggio per valore (la variabile non cambia fuori dal metodo)
        modificaVariabilePrimitiva(x);

        // Passaggio per riferimento (l'array viene modificato)
        modificaArray(a);

        System.out.println("Dopo la modifica");
        System.out.println("Valore x: " + x);
        System.out.println("Primo valore dell'array: " + a[0]);
    }

    // Metodo iterativo per calcolare il fattoriale
    public static int fattoriale(int num) {

        // Controllo input non valido
        if (num < 0) {
            System.out.println("Errore fattoriale");
            return -1;
        }

        int risultato = 1;

        // Ciclo per calcolare il fattoriale
        for (int i = 1; i <= num; i++) {
            risultato *= i;
        }

        return risultato;
    }

    // Overload del metodo fattoriale per gestire input non numerico
    public static void fattoriale(String valore) {
        System.out.println("Inserisci un numero valido");
    }

    // Metodo ricorsivo per il fattoriale
    public static int fattorialeRicorsivo(int num) {

        // Caso base
        if (num == 0 || num == 1) {
            return 1;
        }

        // Chiamata ricorsiva
        return num * fattorialeRicorsivo(num - 1);
    }

    // Metodo per sommare due numeri
    public static int somma(int a, int b) {
        return a + b;
    }

    // Metodo per moltiplicare due numeri
    public static int multply(int a, int b) {
        return a * b;
    }

    // Overload: moltiplicazione di tre numeri (double)
    public static double multply(double a, double b, double c) {
        return a * b * c;
    }

    // Metodo ricorsivo per sommare i numeri naturali fino a num
    public static int sommaNaturali(int num){

        // Caso base
        if (num == 1) {
            return 1;
        }
        else{
            // Chiamata ricorsiva
            return num + sommaNaturali(num - 1);
        }
    }

    // Metodo che prova a modificare una variabile primitiva
    public static void modificaVariabilePrimitiva(int x){
        x = 200; // Non cambia fuori dal metodo devo sistemare
    }

    // Metodo che modifica un array (oggetto)
    public static void modificaArray(int[] a){
        a[0] = 23; // Cambia anche fuori dal metodo anche questo da sistemare
    }
}