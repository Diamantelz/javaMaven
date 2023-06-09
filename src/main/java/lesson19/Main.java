package lesson19;

import lesson16.Person;
import lesson16.PersonAPI;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonAPI.getPersons(10);
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("-------");
        LambdaExample.sortLambda(persons, new Predicate<>() {
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

        LambdaExample.sortLambda(persons, p -> p.getCountry().equals("Spain"), c -> {
            c.setCountry("QWE");
            System.out.println(c);});
        System.out.println("-------");

        LambdaExample.sortLambda(persons, p -> p.getCountry().equals("Spain"), c -> {
            c.setCountry("QWE");
            System.out.println(c);}, p -> p.length());

    }
}

interface Predicate<T> {
    boolean test(T t);
}

interface IConsumer<T> {
    void accept(T t);
}

class LambdaExample {
    public static void sortLambda(List<Person> list, Predicate<Person> predicate) {
        for (Person person : list) {
            if (predicate.test(person)) {
                System.out.println(person);
            }
        }
    }
    public static void sortLambda(List<Person> list, Predicate<Person> predicate, IConsumer<Person> consumer) {
        for (Person person : list) {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }
    public static void sortLambda(List<Person> list, Predicate<Person> predicate, IConsumer<Person> consumer,
                                  Function<String, Integer> function) {
        for (Person person : list) {
            if (predicate.test(person)) {
                consumer.accept(person);
                function.apply(person.getCountry());
            }
        }
    }
}
