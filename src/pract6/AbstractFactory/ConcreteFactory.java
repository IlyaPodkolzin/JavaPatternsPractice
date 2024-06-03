package pract6.AbstractFactory;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public ConcreteProduct createProductA() {
        return new ConcreteProduct();
    }

    @Override
    public ConcreteProduct createProductB() {
        return new ConcreteProduct();
    }
}
