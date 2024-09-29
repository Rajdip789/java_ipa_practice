/**
 * Take an alphanumeric string as input and count the number of vowels and consonents present in the string
 */

import java.util.Scanner;

public class program2 {
    public static Boolean isAlphabet(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return true;
        return false;
    }

    public static Boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String strcp = str.toLowerCase();

        int vowel = 0, consonent = 0;

        for(int i = 0; i < strcp.length(); i++) {
            char ch = strcp.charAt(i);

            if(isAlphabet(ch)) {
                if(isVowel(ch)) vowel++;
                else consonent++;
            }
        }

        System.out.println("Number of Vowels: " + vowel);
        System.out.println("Number of Consonents: " + consonent);
    }
}
