package pract8.Mediator;

public class ConcreteMediator extends Mediator {
    @Override
    public void doAction(String action, Colleague colleague) {
        super.doAction(action, colleague);
        System.out.println("Action \"" + action + "\" is performed by colleague \"" + colleague.name + "\"");
    }
}
