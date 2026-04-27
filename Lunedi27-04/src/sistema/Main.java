package sistema;

public class Main {
    public static void main(String[] args) {

        //Animal myAnimal= new Animal();// Dà Errore perchè la classe Astratta non può essere istanziata

        Animal myDog = new Dog();
        Animal myPig = new Pig();

        myDog.animalSound();
        myPig.animalSound();


    }
}