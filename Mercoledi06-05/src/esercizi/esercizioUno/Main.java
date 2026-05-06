package esercizi.esercizioUno;

public class Main {
    public static void main(String[] args) {

        GestioneLuciFacade facadeNormale = new GestioneLuciFacade(new StrategiaNormale());

        facadeNormale.accendiTutte();

        GestioneLuciFacade facadeNotte = new GestioneLuciFacade(new StrategiaNotte());

        facadeNotte.accendiTutte();


    }
}
