package Esercizi.esercizioUno;

public class MessaggioDecorator implements Messaggio {

    protected Messaggio messaggio;

    public MessaggioDecorator(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getContenuto(){
        return this.messaggio.getContenuto();
    }

}
