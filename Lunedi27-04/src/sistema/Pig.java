package sistema;

public class Pig extends Animal {

    @Override
    public void sleed() {
        System.out.println("The pig is sleeping");
    }
    //implementazione del metodo Astratto
    @Override
    public void animalSound() {
        System.out.println("The pig says: weee weee");
    }
}
