package pract1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Integer[]> consumer = (mass) -> {
            Integer[] sorted;
            sorted = Arrays.copyOf(mass, mass.length);
            Arrays.sort(sorted);
            System.out.println(Arrays.toString(sorted));
        };

        Integer[] massive = {1, 65, 2, 4, 67, 2, 1, 34, 54, 16, 9, 36};
        System.out.print("Отсортированный массив: ");
        consumer.accept(massive);
        System.out.println("Исходный массив: " + Arrays.toString(massive));
    }
}
