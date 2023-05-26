package lesson18;

import java.util.Random;

public class Game  {
    public static <T extends Employee> void printWinner(T e1, T e2) {
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1) {
            System.out.println(e1.getName());
        } else {
            System.out.println(e2.getName());
        }
    }
}
