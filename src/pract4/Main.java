package pract4;


public class Main {
    public static void main(String[] args) {
        ExecutorService2GrandProdolzhenie executor = new ExecutorService2GrandProdolzhenie(3);
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("������ 1");
        });
        executor.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("������ 2");
        });
        System.out.println("����� �����");
        executor.shutdown();
    }
}
