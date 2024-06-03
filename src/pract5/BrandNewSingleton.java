package pract5;

import java.util.Random;

public class BrandNewSingleton {
    private final int x;

    protected BrandNewSingleton() {
        x = (new Random()).nextInt();
    }

    public int getX() {
        return x;
    }
}
