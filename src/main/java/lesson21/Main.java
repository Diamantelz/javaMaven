package lesson21;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(21, 2, 0, 13, 4, 5, 64, 374, 102, 25, 1989, 30, 5, 5, 90, 47, 3)
                .skip(5)
                .limit(7)
                .forEach(System.out::println);
        System.out.println("-------");

        OptionalDouble average = Stream.of(21, 2, 0, 13, 4, 5, 64, 374, 102, 25, 1989, 30, 5, 5, 90, 47, 3)
                .mapToInt(x -> x)
                .average();
        System.out.println(average);
        System.out.println("-------");

        Stream.of(21, 2, 0, 13, 4, 5, 64, 374, 102, 25, 1989, 30, 5, 5, 90, 47, 3)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("-------");

    }
}
