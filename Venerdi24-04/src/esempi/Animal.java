package esempi;

/*
 * CLASSE ASTRATTA:
 * Animal rappresenta un concetto generico.
 * Non voglio creare un "Animal" generico,
 * ma voglio creare animali specifici come Dog o Pig.
 */
abstract class Animal {

    /*
     * METODO ASTRATTO:
     * Ogni animale emette un verso diverso.
     * Per questo non lo implemento qui,
     * ma obbligo le classi figlie a definirlo.
     */
    abstract void animalSound();
}