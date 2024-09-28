/**
 * Write the main method in the Solution class. In the main method, 
 * write code to read a numeric digit(without any alphabets or special characters) using Scanner 
 * and print it in the reverse sequence as they appear in the input. Consider below sample input and output:
 * Input: 12345
 * Output: The reverse of the number is 54321.
 **/

import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int rev = 0;

        while(num > 0) {
            int digit = num%10;
            num = num / 10;
            rev = rev*10 + digit;
        }

        System.out.println("The reverse of the number is " + rev);
    }
}
