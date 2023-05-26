package lesson17;

import org.apache.log4j.Logger;

public class Performer3 extends Thread {
    public static final Logger LOGGER = Logger.getLogger(Performer3.class);
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MICROPHONE) {
                try {
                    LOGGER.debug("Певец 3 ждет");
                    Monitors.MICROPHONE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LOGGER.debug("Певец 3 начал петь");
            for (int i = 0; i < 3; i++) {
                System.out.println("ra-ra-ra");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MICROPHONE) {
                LOGGER.debug("Певец 3 передал микрофон");
                Monitors.MICROPHONE.notify();
            }
        }
    }
}
