package lesson17;

import org.apache.log4j.Logger;

public class Performer1 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Performer1.class);
    private int count = 5;
    public Performer1() {
    }

    public Performer1(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int j = 0;
        while (j < count) { //true
            LOGGER.debug("Певец 1 начал петь");
            for (int i = 0; i < 3; i++) {
                System.out.println("la-la-la");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MICROPHONE) {
                LOGGER.debug("Певец 1 передал микрофон");
                Monitors.MICROPHONE.notify();
            }
            synchronized (Monitors.MICROPHONE) {
                try {
                    LOGGER.debug("Певец 1 ждет");
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}
