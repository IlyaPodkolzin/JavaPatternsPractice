package pract3;


public class mainTask {

    static volatile LockMap<Integer, Integer> mapper = new LockMap<>();
    static volatile SemaphoreSet<Integer> setter = new SemaphoreSet<>();

    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                mapper.put(i, i * i);
            }
            for (int i = 0; i < 10; i++) {
                mapper.remove(i * 2);
            }
            System.out.println(mapper);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (!mapper.containsKey(i))
                    mapper.put(i, i * 100);
            }
            for (int i = 0; i < 9; i++) {
                mapper.remove(i * i);
            }
            System.out.println(mapper);
        });

        thread1.start();
        Thread.sleep(1500);
        thread2.start();
        Thread.sleep(1500);

        System.out.println();
        System.out.println();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                setter.add(i * i);
            }
            for (int i = 0; i < 10; i++) {
                setter.remove(i * 2);
            }
            System.out.println(setter);
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                setter.remove(i * 3);
            }
            System.out.println(setter);
        });

        thread3.start();
        Thread.sleep(1500);
        thread4.start();
    }
}
