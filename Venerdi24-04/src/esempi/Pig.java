package esempi;

/*
 * Pig eredita da Animal e implementa Movement.
 * Anche Pig è obbligato a implementare animalSound(), move() e run().
 */
public class Pig extends Animal implements Movement {

    /*
     * POLIMORFISMO:
     * animalSound() esiste anche in Dog,
     * ma qui ha un comportamento diverso.
     */
    @Override
    void animalSound() {
        System.out.println("Esercizio.Pig says: weee weee");
    }

    @Override
    public void move() {
        System.out.println("Esercizio.Pig is moving");
    }

    @Override
    public void run() {
        System.out.println("Esercizio.Pig is running");
    }
}