/* 
 * Check if two strings are anagram of each other.
 */

import java.util.Scanner;

public class program7 {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);

            freq[ch1 - 'a']++;
            freq[ch2 - 'a']--;
        }

        for(int f : freq) {
            if(f != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
	    String s = sc.nextLine();
	    String t = sc.nextLine();
	    
	    if(isAnagram(s,t)){
	        System.out.println("true");
	    }
	    else{
	        System.out.println("false");
	    }
	}
}
