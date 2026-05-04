package Esercizi.esercizioDue;

public class FormaggioDecorator extends HamburgerDecorator {

    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione()+", formaggio: ";
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo()+0.50;
    }
}
