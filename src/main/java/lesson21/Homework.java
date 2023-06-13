package lesson21;

import lesson16.Person;
import lesson16.PersonAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
//        1) запросить 100 персонажей.
        List<Person> persons = PersonAPI.getPersonFromAPI(100);
        System.out.println("--------------");

//        2) раскидать гендерно и получить 2 листа с мужчинами и женщинами.
        Map<String, List<Person>> collectedPersons = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        List<Person> female = new ArrayList<>();
        List<Person> male = new ArrayList<>();
        for (Map.Entry<String, List<Person>> entrySetList : collectedPersons.entrySet()) {
            if (entrySetList.getKey().equals("female")) {
                female = entrySetList.getValue();
            }
            if (entrySetList.getKey().equals("male")) {
                male = entrySetList.getValue();
            }
        }

//        3) от этих листов так же найти наиболее и наименее взрослого / взрослую и вывести.
        System.out.print("max female age: ");
        female.stream()
                .mapToInt(Person::getAge)
                .max()
                .ifPresent(System.out::println);

        female.stream()
                .max((o1, o2) -> o1.getAge() - o2.getAge())
                .ifPresent(System.out::println);

        System.out.print("min female age: ");
        female.stream()
                .mapToInt(Person::getAge)
                .min()
                .ifPresent(System.out::println);

        female.stream()
                .min((o1, o2) -> o1.getAge() - o2.getAge())
                .ifPresent(System.out::println);

        System.out.print("max male age: ");
        male.stream()
                .mapToInt(Person::getAge)
                .max()
                .ifPresent(System.out::println);

        male.stream()
                .max((o1, o2) -> o1.getAge() - o2.getAge())
                .ifPresent(System.out::println);

        System.out.print("min male age: ");
        male.stream()
                .mapToInt(Person::getAge)
                .min()
                .ifPresent(System.out::println);

        male.stream()
                .min((o1, o2) -> o1.getAge() - o2.getAge())
                .ifPresent(System.out::println);
        System.out.println("--------------");

//        4) посчитать количество в каждом списке.
        System.out.println("female list size: " + female.size());
        System.out.println("male list size: " + male.size());
        System.out.println("--------------");

//        5) вывести средний возраст мужчин и отдельно средний возраст женщин.
        System.out.print("average female age: ");
        female.stream()
                .mapToInt(Person::getAge)
                .average()
                .ifPresent(System.out::println);

        System.out.print("average male age: ");
        male.stream()
                .mapToInt(Person::getAge)
                .average()
                .ifPresent(System.out::println);
        System.out.println("--------------");

//        6) посчитать общий возраст мужчин и женщин
        System.out.print("total female age: ");
        female.stream()
                .mapToInt(Person::getAge)
                .reduce((accumulator, age) -> accumulator + age)
                .ifPresent(System.out::println);

        System.out.print("total male age: ");
        male.stream()
                .mapToInt(Person::getAge)
                .reduce((accumulator, age) -> accumulator + age)
                .ifPresent(System.out::println);
        System.out.println("--------------");
    }
}
