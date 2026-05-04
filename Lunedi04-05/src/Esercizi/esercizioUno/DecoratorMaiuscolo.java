package Esercizi.esercizioUno;

public class DecoratorMaiuscolo extends MessaggioDecorator {


    public DecoratorMaiuscolo(Messaggio messaggio) {
        super(messaggio);
    }

    @Override
    public String getContenuto() {
        return messaggio.getContenuto().toUpperCase();
    }
}
