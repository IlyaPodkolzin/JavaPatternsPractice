package pract5;

public class Main {
    public static void main(String[] args) {
        SingletonVersion1 instance11 = SingletonVersion1.getInstance();
        SingletonVersion1 instance12 = SingletonVersion1.getInstance();
        System.out.println(instance11.getX() + " = " + instance12.getX());

        SingletonVersion2 instance21 = SingletonVersion2.INSTANCE;
        SingletonVersion2 instance22 = SingletonVersion2.INSTANCE;
        System.out.println(instance21.getX() + " = " + instance22.getX());

        SingletonVersion3 instance31 = SingletonVersion3.instance;
        SingletonVersion3 instance32 = SingletonVersion3.instance;
        System.out.println(instance31.getX() + " = " + instance32.getX());
    }
}
