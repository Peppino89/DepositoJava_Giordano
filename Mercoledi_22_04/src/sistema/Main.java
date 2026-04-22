package sistema;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Marco",32,"Francia","Vai via delle vie, 32");

        System.out.println(persona.indirizzo);
        persona.Saluta();
    }
}