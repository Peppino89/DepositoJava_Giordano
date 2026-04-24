package esempi;

/*
 * INTERFACCIA:
 * Definisce un comportamento comune.
 * Tutte le classi che implementano Movement
 * devono avere i metodi move() e run().
 */
public interface Movement {

    /*
     * Nei metodi delle interfacce public abstract è implicito.
     */
    void move();

    void run();
}