import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;;

class collections {

    static void strings() {
        /* String vs StringBuffer vs StrginBuilder 
         * 1. String is immutable whereas StringBuffer and StringBuilder are mutable class.
         * 2. StringBuffer is thread-safe and synchronized whereas stringBuilder is not, thats why StringBuilder is fast.
         * 3. String concatination(+) operator creates a new String object each time, whereas StringBuilder is appends only so fast.
         * 4. StringBuffer - for using in a Multithread Environment, else use StringBuffer
         * 
         * 5. String is imutable in java because of security, synchronization and concurrency, caching and class loading.
         * 6. String pool requires string to be immutable otherwise shared reference can be changed from anywhere.
        */

        StringBuffer sb = new StringBuffer("Rajdip");
        sb.append("Pal");

        StringBuilder sb2 = new StringBuilder("Rajdip");
        sb2.append("Pal");

        String str1 = "Rajdip Pal";
        String str2 = "Hritwick De";
        String str3 = "Rajdip Pal";

        String str4 = new String("Rajdip Pal");
 
        System.out.println(str1 == str3);  // o/p: true (both point to the same literal in the string pool)
        System.out.println(str1 == str4);  // o/p: false (different memory locations)

        System.out.println(str1.compareTo(str2)); //Compare strings lexicographically (O/P - 10)
        System.out.println(str1.equals(str2)); // Compare two strings returns boolean
        System.out.println(str1.equalsIgnoreCase(str2)); // Compare two strings (not case sensitive), returns boolean        
    }

    static void iteratorsAndOptional() {

        List<Integer> ls = List.of(8, 20, 7, 11);
        Iterator<Integer> it = ls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[6]);

        if(words[6] == null) System.out.println("This is null"); // without optional
        if(checkNull.isPresent()) {                                // with optional
            System.out.println(words[6].toLowerCase());
        } else {
            System.out.println("Word is null");
        }
    }

    static void listAndStream() {
        /* List and Stream */

        List<Integer> list = List.of(4, 4, 2, 1, 5, 4, 10, 9, 17);
        List<Integer> newList = list.stream().map(i -> i * i).collect(Collectors.toList());
        newList.forEach(i -> System.out.println(i));
        Integer mini = list.stream().min((x, y) -> x > y ? x : y).get(); // find min in a list
        System.out.println(mini);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.frequency(list, 4));

        Collections.sort(list);
        Collections.sort(list, Comparator.reverseOrder());
        Collections.sort(list, (a, b) -> a < b ? a : b);

        String names[] = { "Cat", "Dog", "Snake", "Cow", "Tiger", "Lion" };
        Stream<String> stm = Stream.of(names);
        stm.forEach(System.out::println); // The stream(stm) consumed here can't be used later
        Stream.of(names).sorted().forEach(System.out::println);

        List<String> strList = new ArrayList<String>();
        strList.add("Raj");
        strList.add("Sandip");
        strList.add("Hritwick");
        strList.add("Priyo");

        Collections.sort(strList, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length()); // can use this also s1.length() > s2.length() ? 1 : -1;
            }
        });
        System.out.println(strList);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4); // we can modify the elements but can't add and remove
        list2.set(1, 10);
        System.out.println(list2.size());
        // list2.add(5); //unsupported
    }

    public static void main(String[] args) {
        strings();
        iteratorsAndOptional();
        listAndStream();
    }
}