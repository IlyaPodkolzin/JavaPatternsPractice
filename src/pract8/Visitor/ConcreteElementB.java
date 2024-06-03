package pract8.Visitor;

public class ConcreteElementB implements Element{
    @Override
    public void accept(BNVisitor bnVisitor) {
        System.out.println("Concrete Element B is accepted.");
    }
}
