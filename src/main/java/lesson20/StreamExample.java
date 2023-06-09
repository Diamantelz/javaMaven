package lesson20;

import lesson16.Person;
import lesson16.PersonAPI;
import lesson18.Tester;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personsFromAPI = PersonAPI.getPersonFromAPI(10);
        for (Person person : personsFromAPI) {
            System.out.println(person);
        }
        System.out.println("-------");
        List<Person> peopleFromSpain = personsFromAPI.stream()
                .filter(p -> p.getCountry().equals("Spain"))
//                .forEach(p -> System.out.println(p));
                .collect(Collectors.toList());
        System.out.println("-------");

        List<String> usernames = personsFromAPI.stream()
                .map(person -> person.getUsername())
                .collect(Collectors.toList());
        System.out.println("-------");

        List<Tester> testers = personsFromAPI.stream()
                .map(person -> new Tester(person.getName(), person.getAge()))
                .collect(Collectors.toList());
    }
}
