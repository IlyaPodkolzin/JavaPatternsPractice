package pract5;

public class SingletonVersion3 extends BrandNewSingleton {
    public static final SingletonVersion3 instance = new SingletonVersion3();

    private SingletonVersion3() {
        super();
    }
}
