package lesson20;

import lesson16.Person;
import lesson16.PersonAPI;

import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        List<Person> personsFromAPI = PersonAPI.getPersonFromAPI(10);
        for (Person person : personsFromAPI) {
            System.out.println(person);
        }
        System.out.println("--------");

        // вывести только женщин старше 20 лет
        personsFromAPI.stream()
                .filter(p -> p.getGender().equals("female") && p.getAge() > 20)
                .forEach(System.out::println);
        System.out.println("--------");

        // найти мужчин младше 18 лет и вывести значение в виде фамилии, имени и даты рождения
        List<String> men = personsFromAPI.stream()
                .filter(p -> p.getGender().equals("male") && p.getAge() < 48)
                .map(p -> p.getName() + " " + p.getLastName() + " " + p.getDate().toLocalDate())
                .collect(Collectors.toList());

        men.stream()
                .forEach(System.out::println);
        System.out.println("--------");

        // найти людей старше 50 лет и сохранить их в отдельный лист
        List<Person> personsOver50 = personsFromAPI.stream()
                .filter(p -> p.getAge() > 50)
                .collect(Collectors.toList());

        personsOver50.stream()
                .forEach(System.out::println);
        System.out.println("--------");

        // вывести всех, у кого длина имени и фамилии меньше 15 символов
        List<String> collected = personsFromAPI.stream()
                .map(p -> p.getName() + " " + p.getLastName())
                .filter(name -> name.length() < 15)
                .collect(Collectors.toList());

        collected.stream()
                .forEach(System.out::println);
    }
}
