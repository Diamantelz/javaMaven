package lesson21;

import lesson16.Person;
import lesson16.PersonAPI;

import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personsFromAPI = PersonAPI.getPersonFromAPI(10);
        for (Person person : personsFromAPI) {
            System.out.println(person);
        }
        System.out.println("--------");

        personsFromAPI.stream()
                .map(p -> p.getAge())
                .reduce((acc, x) -> acc + x);

        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce(0, (acc, x) -> acc + x);
        System.out.println(reduce);
        System.out.println("--------");

        personsFromAPI.stream()
                .sorted((o1, o2) -> {
                    if(!o1.getName().equals(o2.getName()))
                        return o1.getName().compareTo(o2.getName());
                    return 0;
                })
                .forEach(System.out::println);
        System.out.println("--------");

        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> integerStream2 = Stream.of(6, 7, 8, 9);
        Stream.concat(integerStream1, integerStream2)
                .forEach(System.out::println);
        System.out.println("--------");

        Stream<Integer> integerStream3 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> integerStream4 = Stream.of(6, 7, 8, 9, 9);
        Stream.concat(integerStream3, integerStream4)
                .distinct()
                .forEach(System.out::println);
        System.out.println("--------");

        Stream<Integer> integerStream5 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> integerStream6 = Stream.of(6, 7, 8, 9, 9);
        long count = Stream.concat(integerStream5, integerStream6)
                .distinct()
                .peek(System.out::println)
                .count();
        System.out.println("count: " + count);
        System.out.println("--------");
    }
}
