package lesson17;

import org.apache.log4j.Logger;

public class Performer2 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Performer2.class);
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MICROPHONE) {
                try {
                    LOGGER.debug("Певец 2 ждет");
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LOGGER.debug("Певец 2 начал петь");
            for (int i = 0; i < 3; i++) {
                System.out.println("na-na-na-na");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MICROPHONE) {
                LOGGER.debug("Певец 2 передал микрофон");
                Monitors.MICROPHONE.notify();
            }
        }
    }
}
