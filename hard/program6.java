/*
Create a class Resort with the below attributes:

resortId - int
resortName - String
category - String
price - double
rating - double
The above attribute should be private, write getters, setters and prameterized constructor as required.

Create class Solution with main method.

Implement a static method - findAvgPriceByCategory in Soltion class.

findAvgPriceByCategory method:
This method wil take two input prameters - array of Resort objects and String prameter.
This method will return the average price of Resort(as int value) from array of Resort objects for the given category(String parameter passed) and whose rating is greated than 4.
If no Resort with the above condition is present in the array of Resort objects, the method should return 0..

Note: All the searches should be case insensitive.
*/

import java.util.Scanner;
import java.util.Arrays;

class  Resort {
    private int resortId;
    private String resortName;
    private String category;
    private double price;
    private double rating;

    public Resort(int resortId, String resortName, String category, double price, double rating) {
        this.resortId = resortId;
        this.resortName = resortName;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    int getResortId() {
        return this.resortId;
    }

    String getResortName() {
        return this.resortName;
    }

    String getCategory() {
        return this.category;
    }

    double getPrice() {
        return this.price;
    }

    double getRating() {
        return this.rating;
    }
}

public class program6 {
    public static int findAvgPriceByCategory(Resort[] resort, String category) {
        int price = 0;
        int count = 0;

        for(Resort rs : resort) {
            if(rs.getCategory().equalsIgnoreCase(category) && rs.getRating() > 4) {
                price += rs.getPrice();
                count++;
            }
        }

        if(count == 0) return 0;
        return price/count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Resort rs[] = new Resort[4];

        for(int i = 0; i < rs.length; i++) {
            int inputResortId = sc.nextInt();
            sc.nextLine();
            String inputResortName = sc.nextLine();
            String inputCategory = sc.nextLine();
            double inputPrice = sc.nextDouble();
            sc.nextLine();
            double inputRating = sc.nextDouble();
            sc.nextLine();
            rs[i] = new Resort(inputResortId, inputResortName, inputCategory, inputPrice, inputRating);
        }

        String category = sc.nextLine();

        int avg = findAvgPriceByCategory(rs, category);

        if(avg > 0) {
            System.out.println("Average price of the " + category + " Resort: " + avg);
        } else {
            System.out.println("There are no such available resort");
        }

    }
}

/*

--- input ---
1005
Samudra
3 star
3500.00
3.5
1001
O by Tamara
5 star
7500.00
4
1007
Edens resort
3 star
2500.00
4.7
1003
Tea Valley
3 star
4600.00
4.3
3 star

--- output ---
Average price of the 3 star Resort: 3550

*/