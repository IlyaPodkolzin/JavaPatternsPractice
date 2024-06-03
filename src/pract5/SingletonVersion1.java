package pract5;

public class SingletonVersion1 extends BrandNewSingleton {
    private static  SingletonVersion1 instance;

    public static SingletonVersion1 getInstance() {
        if (instance == null)
            instance = new SingletonVersion1();
        return instance;
    }

    private SingletonVersion1() {
        super();
    }
}
