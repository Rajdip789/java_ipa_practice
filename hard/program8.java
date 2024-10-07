/*
Create a class HeadSets with below attributes:

headSetName - String
brand - String
price - int 
available - boolean

The above attributes should be private, write getters, setters and pramaterized constructor as required

Create class Solution with main method.

Implement two static methods - findTotalPriceForGivenBrand and findAvailableHeadsetWithSecondMinPrice in Solution class.

findTotalPriceForGivenBrand method:
    The method will return the total price of Headsets from array of Headsets objects for the
    given brand (String paramter passed).
    If no Headsets with the given brand is present in the array of Headsets objects, then the 
    method should return 0.
    
findAvailableHeadsetWithSecondMinPrice method:

    This method will take array of Headset objects as an input parameter and returns the 
    available Headset object with the second lowest/minimum price from the given array of
    objects.

    If no Headsets with the above condition is present in the array of Headsets objects, then
    method should return null.

Note: No two Headsets will have the same price.
    All the searches should be case insensitive.

 */

import java.util.Scanner;
import java.util.Optional;

class HeadSets {
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headSetName, String brand, int price, boolean available) {
        this.headsetName = headSetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getHeadsetName() {
        return this.headsetName;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean getAvailability() {
        return this.available;
    }
}

public class program8 {
    public static int findTotalPriceForGivenBrand(HeadSets[] hs, String brand) {
        int price = 0;

        for(HeadSets headSet : hs) {
            if(headSet.getBrand().equalsIgnoreCase(brand)) {
                price += headSet.getPrice();
            }
        }

        return price;
    } 

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] hs) {
        int count = 0;

        for(HeadSets headset : hs) {
            if(headset.getAvailability()) {
                count++;
            }
        }

        HeadSets[] newHs = new HeadSets[count];

        int k = 0;
        for(HeadSets headset : hs) {
            if(headset.getAvailability()) {
                newHs[k++] = headset;
            }
        }

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < count-i-1; j++) {
                if(newHs[j].getPrice() > newHs[j+1].getPrice()) {
                    HeadSets temp = newHs[j];
                    newHs[j] = newHs[j+1];
                    newHs[j+1] = temp;
                }
            }
        }

        if(count > 0) return newHs[1];
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HeadSets[] hs = new HeadSets[4];

        for(int i = 0; i < hs.length; i++) {
            String name = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            boolean available = sc.nextBoolean();
            sc.nextLine();

            hs[i] = new HeadSets(name, brand, price, available);
        }

        String inputBrand = sc.nextLine();

        int price = findTotalPriceForGivenBrand(hs, inputBrand);

        if(price > 0) {
            System.out.println(price);
        } else {
            System.out.println("No Headsets available with the given brand");
        }

        Optional<HeadSets> res = Optional.ofNullable(findAvailableHeadsetWithSecondMinPrice(hs));

        if (res.isPresent()) {
            HeadSets h = res.get();
            System.out.println(h.getHeadsetName());
            System.out.println(h.getPrice());
        } else {
            System.out.println("No Headsets abailable");
        }
    }
}

/**
 
--- input ---
boAt BassHeads
boAt
1220
true
Over Ear Wired
boAt
549
true
In Ear with Mic
JBL
450
true
Buds 2 Neo
RealMe
500
true
boAt

--- output ---
1769
Buds 2 Neo
500

 * /