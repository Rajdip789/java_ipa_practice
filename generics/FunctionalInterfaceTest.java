package generics;

import java.util.function.*;

/**
 * @FunctionalInterface
 * public interface Predicate<T> {
 *      boolean test(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface Function<T, R> {
 *      R apply(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BiFunction<T, U, R> {
 *      R apply(T t, U u);
 * }
 * 
 * @FunctionalInterface
 * public interface Consumer<T> {
 *      void accept(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface Supplier<T> {
 *      T get();
 * }
 * 
 * @FunctionalInterface
 * public interface UnaryOperator<T> extends Function<T, T> {
 *      T apply(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BinaryOperator<T> extends BiFunction<T, T, T> {
 *      T apply(T t, T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BiPredicate<T, U> {
 *      boolean test(T t, U u);
 * }
 * 
 * @FunctionalInterface
 * public interface BiConsumer<T, U> {
 *      void accept(T t, U u);
 * }
 **/

public class FunctionalInterfaceTest {
    public static void main(String[] args) {

        // Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Predicate: Is 4 even? " + isEven.test(4));
        System.out.println("Predicate: Is 7 even? " + isEven.test(7));

        // Function
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Function: Length of 'Java'? " + stringLength.apply("Java"));

        // BiFunction
        BiFunction<String, String, String> concatenator = (s1, s2) -> s1 + s2;
        String combined = concatenator.apply("Hello, ", "World!");
        System.out.println("BiFunction: Concatenation: " + combined);

        // Consumer
        Consumer<String> printUpperCase = str -> System.out.println("Consumer: " + str.toUpperCase());
        printUpperCase.accept("example");

        // Supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Supplier: Random value: " + randomValue.get());

        // UnaryOperator
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("UnaryOperator: Square of 5: " + square.apply(5));

        // BinaryOperator
        BinaryOperator<Integer> adder = (a, b) -> a + b;
        System.out.println("BinaryOperator: 10 + 20 = " + adder.apply(10, 20));

        // BiPredicate
        BiPredicate<String, String> areEqual = (s1, s2) -> s1.equals(s2);
        System.out.println("BiPredicate: 'apple' equals 'apple'? " + areEqual.test("apple", "apple"));
        System.out.println("BiPredicate: 'apple' equals 'orange'? " + areEqual.test("apple", "orange"));

        // BiConsumer
        BiConsumer<String, Integer> printRepeated = (str, count) -> {
            for (int i = 0; i < count; i++) {
                System.out.print(str + " ");
            }
            System.out.println();
        };
        printRepeated.accept("Repeat", 3);
    }
}