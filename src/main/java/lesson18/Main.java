package lesson18;

public class Main {
    public static void main(String[] args) {
        Developer d1 = new Developer("Anton", 24);
        Developer d2 = new Developer("Ilya", 20);

        Tester t1 = new Tester("Danya", 21);
        Tester t2 = new Tester("Simon", 25);

        Game.printWinner(d1, t2);
    }
}
