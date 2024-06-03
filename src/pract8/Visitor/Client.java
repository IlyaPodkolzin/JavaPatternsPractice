package pract8.Visitor;

public class Client {

    public static void main(String[] args) {
        ConcreteVisitor concreteVisitor = new ConcreteVisitor();

        ConcreteElementA concreteElementA = new ConcreteElementA();
        ConcreteElementB concreteElementB = new ConcreteElementB();

        concreteVisitor.visitElementA(concreteElementA);
        concreteVisitor.visitElementB(concreteElementB);
    }
}
