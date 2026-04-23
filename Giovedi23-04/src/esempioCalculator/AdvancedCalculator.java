package esempioCalculator;

public class AdvancedCalculator extends  Calculator{

    @Override
    public int add(int a, int b) {
        int somma = a+b;
        System.out.println("La somma di 2 numeri interi è: "+somma);
        return somma;
    }

    @Override
    public double add(double a, double b) {
        double somma = a+b;
        System.out.println("La somma di 2 numeri double è: "+somma);
        return somma;
    }
}
