package gestioneHotel;

public class Suite extends Camera{

    private String serviziExtra;

    public Suite(String serviziExtra,int numero,float prezzo) {
        super(numero,prezzo);
        this.serviziExtra=serviziExtra;
    }

    public void setServiziExtra(String serviziExtra){
        this.serviziExtra = serviziExtra;
    }
    public String getServiziExtra(){
        return serviziExtra;
    }

    @Override
    public void dettagli(){
        super.dettagli();
        System.out.println("Servizio Extra: "+serviziExtra);
    }

    @Override
    public void dettagli(boolean conPrezzo) {
        super.dettagli(conPrezzo);
        System.out.println("Servizio Extra: "+serviziExtra);
    }

}
