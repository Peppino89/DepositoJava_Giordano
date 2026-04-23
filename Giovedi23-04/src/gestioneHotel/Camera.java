package gestioneHotel;

public class Camera {

    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void dettagli(){
        System.out.println("Numero Camera: "+getNumero()+" prezzo: "+getPrezzo());
    }

    public void dettagli(boolean conPrezzo){
        if(conPrezzo){
            dettagli();
        }else{
            System.out.println("Numero Camera: "+getNumero());
        }
    }
}
