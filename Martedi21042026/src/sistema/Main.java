package sistema;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Auto auto1 = new Auto();
        ArrayList<Auto>listaAuto =  new ArrayList<>();

        auto1.marca = "Mazerati";
        auto1.modello = "Grecale";
        auto1.anno =2020;
        auto1.prezzo=80000.00;

        //auto1.mostraInfo();

        listaAuto.add(auto1);


        Auto auto2 = new Auto();

        auto2.marca = "Nissan";
        auto2.modello = "Juke";
        auto2.anno = 2021;
        auto2.prezzo = 35000;

       // auto2.mostraInfo();
        listaAuto.add(auto2);

        for (Auto auto : listaAuto) {
            auto.mostraInfo();
            System.out.println(Auto.numeroRuote);
            Auto.camabiaNumeroRuote(2);
        }

        Auto auto3 = new Auto("Nissan","Micra",2020,20000.00);






//        Libro libro1 = new Libro("Il Signore degli anelli","J.R.R Tolkien",13.00);
//        Libro libro2 = new Libro("Harry Potter e la pietra filosofale", "J. K. Rowling", 10.23);
//
//        libro1.mostraDettagli();
//        libro2.mostraDettagli();
//
//        System.out.println(Libro.codice_numerico_autoincrementante);


//        Persona persona1 = new Persona("Pippo","Rossi");
//        Persona persona2 = new Persona("Paperino","Duck","Milano");
//        Persona persona3 = new Persona();
//
//        persona1.mostraDettagli();
//        persona2.mostraDettagli();
//        persona3.mostraDettagli();


    }
}