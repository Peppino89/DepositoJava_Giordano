package Esercizi.esercizioDue;

import DecoratorPattern.Decorator;

public class BaconDecorator extends HamburgerDecorator {

    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione()+", bacon";
    }

    @Override
    public double getPrezzo() {

        return hamburger.getPrezzo()+0.80;
    }

}
