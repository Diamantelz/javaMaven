package lesson17.threads;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            Thread.currentThread().setName("MyThread");
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
