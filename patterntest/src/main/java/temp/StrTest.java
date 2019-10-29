package temp;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StrTest {

    public static void main(String[] args) {

        IntStream.concat(
                IntStream.range(2, 6),
                IntStream.rangeClosed(-1, 2))
                .forEach(System.out::println);
        // 2, 3, 4, 5, -1, 0, 1, 2

        System.out.println();

        IntStream.range(5, 30)
                .limit(12)
                .skip(3)
                .limit(6)
                .skip(2)
                .forEach(System.out::println);
        // 10 11 12 13

        System.out.println();

        // Java 9 task dropWhile
//        IntStream.range(0, 10)
//                .skip(2)
//                .dropWhile(x -> x < 8)
//                .limit( )
//                .forEach(System.out::println);
//        // 5, 6, 7

//        Java 9 takeWhile
//        IntStream.range(0, 10)
//                .skip(3)
//                .takeWhile(x -> x < 5)
//                .limit(3)
//                .forEach(System.out::println);
        // 3, 4

        IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.partitioningBy(i-> i % 2 == 0))
        .entrySet()
                .forEach(System.out::println);
    }
    // false=[1, 3, 5, 7, 9]
    // true=[0, 2, 4, 6, 8]

}
