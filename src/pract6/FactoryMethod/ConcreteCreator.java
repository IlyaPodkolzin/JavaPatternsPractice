package pract6.FactoryMethod;

public class ConcreteCreator extends Creator {
    public static ConcreteProduct factoryMethod() {
        return new ConcreteProduct();
    };
}
