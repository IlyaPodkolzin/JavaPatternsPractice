package pract8.Visitor;

public class ConcreteElementA implements Element{
    @Override
    public void accept(BNVisitor bnVisitor) {
        System.out.println("Concrete Element A is accepted.");
    }
}
