package pract8.Visitor;

public class ConcreteVisitor implements BNVisitor {

    @Override
    public void visitElementA(ConcreteElementA concreteElementA) {
        System.out.println("Concrete Element A is visited.");
    }

    @Override
    public void visitElementB(ConcreteElementB concreteElementB) {
        System.out.println("Concrete Element B is visited.");
    }
}
