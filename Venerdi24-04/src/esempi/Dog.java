package esempi;

/*
 * Dog eredita da Animal.
 * Quindi Dog è un Animal.
 *
 * Dog implementa Movement.
 * Quindi Dog deve obbligatoriamente definire move() e run().
 */
public class Dog extends Animal implements Movement {

    /*
     * Override del metodo astratto animalSound().
     * Qui Dog fornisce la sua versione specifica.
     */
    @Override
    void animalSound() {
        System.out.println("The dog says woof woof");
    }

    /*
     * Metodo obbligatorio perché Dog implementa Movement.
     */
    @Override
    public void move() {
        System.out.println("dog is moving");
    }

    /*
     * Metodo obbligatorio perché Dog implementa Movement.
     */
    @Override
    public void run() {
        System.out.println("dog is running");
    }
}