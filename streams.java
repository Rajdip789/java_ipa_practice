import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Java Streams in Depth
public class streams {
    public static void main(String[] args) {
        /*
         * Collection ---> Create Stream ---> Intermediate Operations ---> Terminal Operations (collect(), reduce(), count() etc.)
        */

        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3500);
        salaryList.add(4500);
        salaryList.add(3000);
        salaryList.add(5000);

        long output  = salaryList.stream().filter((Integer sal) -> sal > 4000).count();
        System.out.println("Total Employee with salary > 4000: " + output);

        /* --- Different ways to create a stream --- */
        // 1. From Collection:
        Stream<Integer> streamFromIntegerList = salaryList.stream();

        // 2. From Array:
        Integer[] salaryArray = {3000, 4000, 3500, 4500};
        Stream<Integer> streamFromIntegerArray1 = Arrays.stream(salaryArray);

        // 3. From Static Method:
        Stream<Integer> streamFromIntegerArray2 = Stream.of(3444, 4000, 1500, 5600, 2000);

        // 4. From Stream Builder:
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1000).add(3000).add(3800);
        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();

        // 5. From Stream Iterate:
        Stream<Integer> streamFromIterate = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);

        /* 
         * ----- Different Intermediate Operations ----- 
         *  Stream intermediate operations are called lazy because they are not
         *  evaluated util a terminal operation is invoked
        */
        String names[] = { "Cat", "Dog", "Snake", "Cow", "Tiger", "Lion" };

        // 1. filter(Predicate<T> predicate) - Filters the element
        List<String> filteredNameList = Arrays.stream(names).filter((String name) -> name.length() <= 3).collect(Collectors.toList());
        
        // 2. map(Function<T, R> mapper) - Used to transform each element
        Stream<String> namesInUpperCase = Arrays.stream(names).map((String name) -> name.toUpperCase());
        
        // 3. flatMap(Function<T, Stream<R>> mapper) - Used to iterate over each element of the complex collection, and helps to flatten it.
        List<List<String>> sentenceList = Arrays.asList(
            Arrays.asList("I", "LOVE", "JAVA"),
            Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
            Arrays.asList("ITS", "VERY", "EASY")
        );
        Stream<String> wordStream1 = sentenceList.stream()
            .flatMap((List<String> sentence) -> sentence.stream());
        
        // 4. distince() - Removes the duplicate from the stream.
        Integer[] arr = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> arrStream = Arrays.stream(arr).distinct(); // o/p = 1, 5, 2, 7, 4, 0, 9
        
        // 5. sorted() - Sorts the elements
        Stream<Integer> arrStream2 = Arrays.stream(arr).sorted(); // we can pass comparator also

        // 6. peek(Consumer<T> action) - Helps to see the itermediate result of the stream which is getting processed
        List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6, 10);
        List<Integer> numberList1 = numbers.stream()
                .filter((Integer val) -> val>2)
                .peek((Integer val) -> System.out.println(val))
                .map((Integer val) -> -1*val)
                .collect(Collectors.toList());

        // 7. limit(long maxSize) - Truncate the stream, to have no longer than given maxSize
        List<Integer> numbersList2 = numbers.stream().limit(3).collect(Collectors.toList());
        
        // 8. skip(long n) - Skip the first n elements of the stream.

        // 9. mapToInt(ToIntFunction<T> mapper) - helps to work with primitive "int" data types
        
        // 10. mapToLong(ToIntFunction<T> mapper)
        
        // 11. mapToDouble(ToIntFunction<T> mapper)


        /* 
         *  ----- Different Terminal Operations ----- 
         *  How many time we can use a single stream ?
         *      Only one. Once Terminal operation is used on a Stream, it is close/consumed
         *  and can't be used again for another terminal operation.
        */

        // 1. forEach(Consumer<T> action) - Perform action on each element of the Stream. Do not returns any value.
        numbers.stream()
            .filter((Integer val) -> val >= 3)  
            .forEach((Integer val) -> System.out.println(val));
    
        // 2. toArray() - Collects the elements of the stream into an Array.
        Object[] filteredNumberType1 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .toArray();

        Integer[] filteredNumberType2 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .toArray((int size) -> new Integer[size]);
            
        // 3. reduce(BinaryOperator<T> accumulator) - does reduction on the elements of the stream. Perform associateive aggregation function

        // 4. collect(collector<T,A,B> collector) - can be used to collects the elements of the stream into an List

        // 5. min(Comparator<T> comparator) and max(Comparator<T> comparator)
        Optional<Integer> minValType1 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .min((Integer val1, Integer val2) -> val1-val2);
        System.out.println(minValType1.get()); // 3

        Optional<Integer> minValType2 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .min((Integer val1, Integer val2) -> val2-val1);
        System.out.println(minValType2.get()); // 10

        Optional<Integer> maxValType1 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .max((Integer val1, Integer val2) -> val1-val2);
        System.out.println(maxValType1.get()); // 10

        Optional<Integer> maxValType2 = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .max((Integer val1, Integer val2) -> val2-val1);
        System.out.println(maxValType2.get()); // 3

        // 6. count() - returns the count of element present in the stream
        System.out.println(numbers.stream().count());

        // 7. anyMatch(Predicate<T> predicate)

        // 8. allMatch(Predicate<T> predicate)

        // 9. noneMatch(Predicate<T> predicate)

        // 10. findFirst()

        // 11. findAny()


        /* 
         * --- Parallel Stream ---
         *  - Helps to perform operation on stream concurrently, taking advantage of multi core CPU.
         *  - ParallelStream() method is used instead of regular stream() method.
         *  - Internally it does:
         *      - Task splitting: it use "spliterator" function to split the data into multiple chunks.
         *      - Task submission and parallel processing: Uses Fork-Join pool technique.
        */

    }
}
