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
         * 
         * 
         * --- String fomatting --- 
         *  String.format("%d %.2f", 5, 5.343)
         *  %s - String
         *  %d - Decimal integer
         *  %f - Floating-point number
         *  %x - Hexadecimal integer
         *  %t - Date/time
         */

        /* ------ String --------*/
        String str1 = "Rajdip Pal";
        String str2 = "Hritwick De";
        String str3 = "Rajdip Pal";
        String str4 = new String("Rajdip Pal");

        System.out.println(str1 == str3); // o/p: true (both point to the same literal in the string pool)
        System.out.println(str1 == str4); // o/p: false (different memory locations)

        System.out.println(str1.compareTo(str2)); // Compare strings lexicographically (O/P - 10)
        System.out.println(str1.equals(str2)); // Compare two strings returns boolean
        System.out.println(str1.equalsIgnoreCase(str2)); // Compare two strings (not case sensitive), returns boolean

        String formattedString = String.format("My name is %s and I am %d years old.", str1, 23);
        System.out.println(formattedString);
        
        System.out.println(str1.length());
        System.out.println(str1.charAt(0));
        System.out.println(str1.substring(7, 10));
        System.out.println(str1.indexOf('j'));
        System.out.println(str1.toUpperCase() + " " + str1.toLowerCase());

        String strWhiteSpaces = " Hello ";
        System.out.println(strWhiteSpaces.trim()); // Returns a string with all leading and trailing spaces remove
        
        String[] strArr = "Hi how are you".split(" ");
        for(String s : strArr) System.out.println(s);


        /* ----- StringBuilder & StringBuffer ------*/
        StringBuilder sb1 = new StringBuilder("Rajdip");
        sb1.append("Pal"); // appends a String or char
        StringBuffer sb2 = new StringBuffer("Rajdip");
        sb2.append("Pal");

        String stringFromStringBuilder = sb1.toString();
        String stringFromStringBuffer = sb2.toString();

        System.out.println(sb1.equals(sb2)); // false, Although contents are equal but both are objects of different classes.
        System.out.println(stringFromStringBuilder.equals(stringFromStringBuffer)); // true
        System.out.println(stringFromStringBuilder == stringFromStringBuffer); //false, Both are different objects created by calling toString() method
    
        int n = sb1.length();
        sb1.setCharAt(1, 'k');
        sb1.reverse(); // Reverse the characters in the sting
        System.out.println(sb1);

        sb1.deleteCharAt(sb1.length()-1);
        sb1.delete(0, 4); // delete from start to end
    }
}
