package lesson18;

public class Main {
    public static void main(String[] args) {
        Developer d1 = new Developer("Anton", 24);
        Developer d2 = new Developer("Ilya", 20);

        Tester t1 = new Tester("Danya", 21);
        Tester t2 = new Tester("Simon", 25);

        Tester t3 = new Tester("Danya", 21);
        Tester t4 = new Tester("Simon", 25);

        Team<Developer> developerTeam = new Team<>();
        Team<Tester> testerTeam1 = new Team<>("team1");
        Team<Tester> testerTeam2 = new Team<>("team2");
        
        developerTeam.addEmployee(d1);
        developerTeam.addEmployee(d2);

        testerTeam1.addEmployee(t1);
        testerTeam1.addEmployee(t2);

        testerTeam2.addEmployee(t3);
        testerTeam2.addEmployee(t4);
        Game.printWinner(testerTeam1, testerTeam2);
    }
}
