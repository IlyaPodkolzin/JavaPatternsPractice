package pract8.Mediator;

public class ConcreteColleague implements Colleague {
    @Override
    public void doAction(String action, Mediator mediator) {
        System.out.println("Action \"" + action + "\" is performed");
    }
}
