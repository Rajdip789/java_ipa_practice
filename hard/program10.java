/*
Create class Inventory with below attributes:
inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Write necessary getters and setters and Consturctors.

Create class Solution and implement statice method "replenish" in the Solution class.

This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is lesser than or equal to the 
original array of Inventory objects's threshold attriburte.

Call the "replenish" method and write logic in main method to print
inventoryId and "Critical Filling", if the threshold attribure is greater than 75.
Else if the threshold attribure is between 50 and 75 then print "Moderate Filling".
Else print "Non-Critical Filling".

*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Inventory {
    private int inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(int inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    int getInventoryId() {
        return this.inventoryId;
    }

    int getThreshold() {
        return this.threshold;
    }
}

public class program10 {
    public static Inventory[] replenish(Inventory[] inventory, int limit) {
        List<Inventory> inv = new ArrayList<Inventory>();

        for(Inventory i : inventory) {
            if(i.getThreshold() <= limit) {
                inv.add(i);
            }
        }

        return inv.toArray(new Inventory[0]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Inventory[] inv = new Inventory[4];

        for(int i = 0; i < inv.length; i++) {
            int inventoryId = sc.nextInt();
            sc.nextLine();
            int maximumQuantity = sc.nextInt();
            sc.nextLine();
            int currentQuantity = sc.nextInt();
            sc.nextLine();
            int threshold = sc.nextInt();
            sc.nextLine();

            inv[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }

        int threshold = sc.nextInt();
        Inventory[] invArr = replenish(inv, threshold);

        for(int i = 0; i < invArr.length; i++) {
            int id = invArr[i].getInventoryId();
            int th = invArr[i].getThreshold();
            if(th > 75) {
                System.out.println(id + " Critical Filling");
            } else if(th >= 50 && th <= 75) {
                System.out.println(id + " Moderate Filling");
            } else {
                System.out.println(id + " Non-Critical Filling");
            }
        }
    }
}

/*

--- input ---
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45

--- output ---
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling

*/