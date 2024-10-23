import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class collections {
    public static void main(String[] args) {
        /**
         * -- CollectionS.sort() and list_name.sort() for only use with java Collections
         * 
         * -- Arrays.sort() for sorting arrays of primitive data types and objects not collections.
         * 
         * -- sorted() works on stream, it returns a stream, we need to covert back into
         *    arrays for using it.
         * 
         * -- Collection - part of java Collection framework, its an interface.
         * -- Collections - is a Utility class and provide static methods, which are
         *    used to operate on collections. like sorting, swappping, searching, reverse, copy etc.
         **/

        /* ---- List and different methods---- */
        
        // 1. ArrayList (Standard - Mutable list)
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(20);
        values.add(21);
        values.add(3);
        values.add(5);
        values.add(8);
        values.add(2);
        values.add(3);

        // Iterating using iterator
        System.out.println("Iterating the values using iterator method: ");
        Iterator<Integer> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            int val = valuesIterator.next();
            System.out.print(val + " ");
            if (val == 20) {
                valuesIterator.remove();
            }
        }

        System.out.println("");
        // Iterating using for-each loop
        for (int val : values)
            System.out.print(val + " ");

        System.out.println("");
        // Iterating using forEach method
        values.forEach(val -> System.out.print(val + " "));

        System.out.println("");
        System.out.println("size: " + values.size());
        System.out.println("isEmpty: " + values.isEmpty());
        System.out.println("contains 5? " + values.contains(5));
        System.out.println("size: " + values.size());
        // remove using index
        values.remove(0);
        // remove using value
        values.remove(Integer.valueOf(21));
        // convert list to an array
        Integer[] arr = values.toArray(new Integer[0]);

        /* ---- Collections methods --- */
        System.out.println("Min value: " + Collections.min(values));
        System.out.println("Max value: " + Collections.max(values));
        System.out.println("Frequency of element 3: " + Collections.frequency(values, 3));

        Collections.reverse(values);
        System.err.println("Values after doing reverse: " + values);

        Collections.sort(values, (a, b) -> b - a); // can use Comparator.reverseOrder() instead
        System.err.println("Values after sorting in reverse order: " + values);

        Collections.sort(values);
        System.err.println("Values after sorting in normal order: " + values);

        // Returns the index of the element, or the index where it should be present
        System.out.println("Index of the element 5: " + Collections.binarySearch(values, 5));

        Collections.swap(values, 0, values.size() - 1);
        System.out.println("After swaping first and last position: " + values);

        System.out.println("");

        List<String> strList = new ArrayList<String>();
        strList.add("Raj");
        strList.add("Sandip");
        strList.add("Hritwick");
        strList.add("Priyo");

        Collections.sort(strList, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // Integer.compare(s1.length(), s2.length()); for sorting by length
            }
        });
        System.out.println("List after soring lexicographically: " + strList);

        // 2. Fixed size list
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4); // we can modify the elements but can't add and remove
        list2.set(1, 10);
        System.out.println(list2.size());
        // list2.add(5); //unsupported

        // 3. List.of() (Imutable list in java 9 and above)
        List<Integer> list = List.of(4, 4, 2, 1, 5, 4, 10, 9, 17);
    }
}