package lesson19;

import lesson16.Person;
import lesson16.PersonAPI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonAPI.getPersons(10);
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("-------");
        LambdaExample.sortLambda(persons, new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 30;
            }
        });
        System.out.println("-------");

        LambdaExample.sortLambda(persons, (Person person) -> {return person.getAge() < 30;});
        System.out.println("-------");

        LambdaExample.sortLambda(persons, p -> p.getAge() < 30);
        System.out.println("-------");
    }
}

interface Predicate<T> {
    boolean test(T t);
}

class LambdaExample {
    public static void sortLambda(List<Person> list, Predicate<Person> predicate) {
        for (Person person : list) {
            if (predicate.test(person)) {
                System.out.println(person);
            }
        }
    }
}
