package esercizi.esercizioUno;

public class GestioneLuciFacade {

   private  LuceCamera luceCamera;
    private LuceCucina luceCucina;
    private Strategy strategy;

    public GestioneLuciFacade(Strategy strategy) {
        this.luceCamera = new LuceCamera();
        this.luceCucina = new LuceCucina();
        this.strategy = strategy;
    }

    public void accendiTutte(){
      strategy.esegui();
      luceCamera.accendi();
      luceCucina.accendi();
    }



}
