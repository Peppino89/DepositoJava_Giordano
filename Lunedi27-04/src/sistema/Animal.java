package sistema;

//Dichiarazione della classe Astratta che non può essere istanziata
abstract class Animal implements AnimalDo {
    @Override
    public void sleed() {
        System.out.println("Dormire Generico");
    }
    // metodo astratto che contiene solo la firma del metodo
public abstract void animalSound();

}
