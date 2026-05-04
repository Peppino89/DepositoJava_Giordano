package Esercizi.esercizioUno;

public class DecoratoreEsclamativo extends MessaggioDecorator {

    public  DecoratoreEsclamativo(Messaggio messaggio) {
        super(messaggio);
    }

    @Override
    public String getContenuto(){
        return messaggio.getContenuto()+"!!!";
    }

}
