/**
 * Write a java program to check whether a given number is perfect square or not
 **/
import java.util.Scanner;

public class program4 {
    public static Boolean isPerfectSquare(int num) {
        for(int i = 1; i * i <= num; i++) {
            if(i*i == num) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(isPerfectSquare(num)) 
            System.out.println("Perfect square");
        else
            System.out.println("Not perfect square");
    }    
}