package lesson16;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // version 1
        Person personFromAPI = PersonAPI.getPersonFromAPI();
        System.out.println(personFromAPI);

        // version 2
        List<Person> personsFromAPI = PersonAPI.getPersonFromAPI(5);
        for (Person person : personsFromAPI) {
            System.out.println(person);
        }

        // version 3
        List<Person> people = PersonAPI.getPersons(10);
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
