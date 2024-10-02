/**
 * Write a java program t oreverse a given string
 * The reverse string should be printed in lowercase only.
**/

public class program3 {
    public static void main(String[] args) {
        String s = new String("Rajdip");
        StringBuilder sb = new StringBuilder(s);

        System.out.println(sb.reverse().toString().toLowerCase());
        
        // another way
        // String s2 = s.toLowerCase();
        // for(int i = s2.length()-1; i >= 0; i--) {
        //     System.out.print(s2.charAt(i));
        // }
    }
}