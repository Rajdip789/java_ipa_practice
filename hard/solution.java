/**
 * Create a Class Medicine with the below attributes:
 * medicine name – String
 * batch no – String
 * disease – String
 * price – int
 * Write getters, setters, and parameterized constructors as required. A public class Solution is already created with the main method. 
 * Code inside the main method should not be altered else your solution might be scored as zero. You may copy the code from the main method in Eclipse to verify your implementation.
 * Implement static method – medicinePriceForGivenDisease in Solution class. 
 *          This method will take a String parameter named disease along with the other parameter as an array of Medicine objects. 
 *          The method will return an array of integers containing the price of the medicines in ascending order 
 *          if the given input(disease) matches the disease attribute of the medicine objects in the Array.
 * Note: 1) Same disease can have more than one medicine.
 * 2) disease search should be case insensitive.
 * This method should be called from the main method and display the prices. The main method mentioned above already has Scanner code to read values, create objects, and test the above methods. Hence do not modify it. 
**/

import java.util.*;

class Medicine {
    private String name;
    private String batch_no;
    private String disease;
    private int price;

    public Medicine(String name, String batch_no, String disease, int price) {
        this.name = name;
        this.batch_no = batch_no;
        this.disease = disease;
        this.price = price;
    }

    public String getDisName() {
        return this.disease;
    }

    public int getPrice() {
        return this.price;
    }
}

public class solution {
    public static int[] medicinePriceForGivenDisease(String dis_name, Medicine[] med) {
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < med.length; i++) {
            if(med[i].getDisName().equalsIgnoreCase(dis_name)) {
                res.add(Integer.valueOf(med[i].getPrice()));
            }
        }

        Collections.sort(res);

        int[] price = new int[res.size()];

        for(int i = 0; i < res.size(); i++) price[i] = res.get(i);

        return price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] arr = new Medicine[4];

        for (int i = 0; i < arr.length; i++) {
          String a = sc.nextLine();
          String b = sc.nextLine();
          String c = sc.nextLine();
          int d = sc.nextInt();
          sc.nextLine();
          arr[i] = new Medicine(a, b, c, d);
        }

        int[] res = medicinePriceForGivenDisease("x", arr);

        for(int it : res) {
            System.out.println(it);
        }
    }
}
