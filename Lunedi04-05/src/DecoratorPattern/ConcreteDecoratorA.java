package DecoratorPattern;

public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component){
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("Aggiunta Funzionalità A");
    }
}
