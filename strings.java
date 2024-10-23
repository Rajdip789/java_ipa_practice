public class strings {
    public static void main(String[] args) {
        /*
         * ---- String vs StringBuffer vs StrginBuilder ----
         * 1. String is immutable whereas StringBuffer and StringBuilder are mutable class.
         * 2. StringBuffer is thread-safe and synchronized whereas stringBuilder is not, thats why StringBuilder is fast.
         * 3. String concatination(+) operator creates a new String object each time, whereas StringBuilder appends only, so fast.
         * 4. StringBuffer - for using in a Multithread Environment, else use StringBuffer
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


        String stringFromStringBuilder = sb.toString();
        String stringFromStringBuffer = sb2.toString();

        System.out.println(str1 == str3); // o/p: true (both point to the same literal in the string pool)
        System.out.println(str1 == str4); // o/p: false (different memory locations)

        System.out.println(str1.compareTo(str2)); // Compare strings lexicographically (O/P - 10)
        System.out.println(str1.equals(str2)); // Compare two strings returns boolean
        System.out.println(str1.equalsIgnoreCase(str2)); // Compare two strings (not case sensitive), returns boolean

    }
}
