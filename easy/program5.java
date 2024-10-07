/**
 * Read a string and find the count of words starting with a vowel in the string. 
 * If no words are present in the String value then it should print "No String found".
 **/

import java.util.Scanner;

public class program5 {
    public static Boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strArr = str.toLowerCase().split(" ");

        int count = 0;

        for(int i = 0; i < strArr.length; i++) {
            if(isVowel(strArr[i].charAt(0))) {
                count++;
            }
        }

        if(count > 0) System.out.println(count);
        else System.out.println("No String found");
    } 
}
