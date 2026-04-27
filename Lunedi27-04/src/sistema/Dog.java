package sistema;

public class Dog extends Animal {
    @Override
    public void sleed() {
        System.out.println("The Dog is sleeping");
    }

    @Override
    public void animalSound() {
        System.out.println("The pig says: bow bow");
    }
}
