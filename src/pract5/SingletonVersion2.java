package pract5;

import java.util.Random;

public enum SingletonVersion2 {
    INSTANCE;
    public SingletonVersion2 getInstance() {
        return INSTANCE;
    }

    private final int x;

    SingletonVersion2() {
        x = (new Random()).nextInt();
    }

    public int getX() {
        return x;
    }
}
