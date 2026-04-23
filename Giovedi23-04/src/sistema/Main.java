package sistema;

public class Main {
    public static void main(String[] args) {
       Auto auto = new Auto("Ak46w");

       System.out.println(auto.brand);
       auto.honk();
       auto.stampaInfo();
    }
}