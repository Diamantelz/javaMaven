package lesson17;

import org.apache.log4j.Logger;

public class Presenter {
    public static final Logger LOGGER = Logger.getLogger(Presenter.class);
    public static void main(String[] args) {
        LOGGER.debug("Ведущий начал концерт");
        System.out.println("Концерт начался");

        Performer1 performer1 = new Performer1(2);
        performer1.setDaemon(true);
        Performer2 performer2 = new Performer2();
        performer2.setDaemon(true);
        Performer3 performer3 = new Performer3();
        performer3.setDaemon(true);
        LOGGER.debug("Ведущий запустил певца 1");
        performer1.start();
        LOGGER.debug("Ведущий запустил певца 2");
        performer2.start();
        LOGGER.debug("Ведущий запустил певца 3");
        performer3.start();

        while (performer1.isAlive()) {
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        LOGGER.debug("Ведущий закончил концерт");
        System.out.println("Концерт закончился");
    }
}
