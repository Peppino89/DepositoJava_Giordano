package Esercizi.esercizioDue;

public class BaseBurger implements Hamburger {


    @Override
    public String getDescrizione() {
        return "Hamburger Base";
    }

    @Override
    public double getPrezzo() {
        return 5.00;
    }
}
