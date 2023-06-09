package lesson18;

import java.util.ArrayList;
import java.util.Objects;

public class Team<T> {
    private String title;
    private ArrayList<T> employees = new ArrayList<>();

    public Team(String title) {
        this.title = title;
    }

    public Team() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!Objects.equals(title, team.title)) return false;
        return Objects.equals(employees, team.employees);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }

    public void addEmployee(T employee) {
        employees.add(employee);
    }
}
