//                     java.lang.Iterable (I)
//                              ^  
//                              |--  Iterator (I)
//                              |--  ListIterator (I) 
//                              |
//                        Collection (I)
//                             ^
//                             |
//       ------------------------------------------------
//      |                      |                        |
//    list (I)               Set (I)                 Queue (I)
//     ^                      ^                        ^
//     |                      |--  HashSet             |--  PriorityQueue
//     |--  ArrayList         |--  LinkedHashSet       |--  BlockingQueue (*)
//     |--  LinkedList(1)     |--  EnumSet(2)          |
//     |--  Vector (*)        |                     Dequeue (I)
//            ^            SortedSet (I)               ^
//            |               ^                        |
//         stack (*)          |                     ArrayDeque
//                       NavigableSet (I)
//                            ^
//                            |
//                         TreeSet
//
// (I) --- Interface
// (*) --- Thread Safe, Synchronized (Vector and Stack are not advised to use as high overhead and slower performance)
// (1) --- LinkedHash also implements Dequeue.
// (2) --- EnumSet also extends AbstractSet. It is highly optimized, much faster than HastSet, not synchronized.
//
//
//                 ---------- Map<K,V> (I)   Serializable (I)      Cloneable (I)
//                 |             |               |                    |  
//       extendes  |             --------------------------------------
//                 |                             |  implements                   AbstractMap<K,V>
//          SortedMap<K,V> (I)          --------------------                          ^
//                 ^                   |                   |                          |
//                 |                HashTable (*)     HashMap<K,V> -------------------
//         NavigableMap<K,V> (I)                           ^    
//                ^                                        |
//             /    \                               LinkedHashMap (1)
//           /       \               
//   TreeMap<k,V>   ConcurrentNavigableMap (I)                  
//                           ^                  
//                           |             
//                   ConcurrentSkipListMap
//
// (I) --- Interface
// (*) --- Thread Safe, Synchronized
// (1) --- LinkedHashMap extends HashMap and implements the Map interface 


package generics;

import java.util.Iterator;

class OurGenericsList<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public OurGenericsList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void add(T item) {
        items[size++] = item;
    }

    public T getItemAtIndex(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurGenericsListIterator(this);
    }
    
    private class OurGenericsListIterator implements Iterator<T> {

        private OurGenericsList<T> list;
        private int index = 0;

        public OurGenericsListIterator(OurGenericsList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
           System.out.println("hasnext called");
           return index < list.size;
        }

        @Override
        public T next() {
            System.out.println("next called");
            return list.items[index++];
        }
    }
}

public class CustomCollectionTest {
    public static void main(String[] args) {
        
        OurGenericsList<Integer> alist = new OurGenericsList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);

        // autoboxing, unboxing
        for(int x : alist) System.out.println(x + " ");

        Iterator<Integer> it = alist.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}