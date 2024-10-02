import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

class Laptop {
    private int laptopId;
    private String brand;
    private String osType;
    private double price;
    private int rating;

    public Laptop(int laptopId, String brand, String osType, double price, int rating) {
        this.laptopId = laptopId;
        this.brand = brand;
        this.osType = osType;
        this.price = price;
        this.rating = rating;
    }

    public int getLaptopId() {
        return this.laptopId;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getOsType() {
        return this.osType;
    }

    public double getPrice() {
        return this.price;
    }

    public int getRating() {
        return this.rating;
    }
}
public class program3 {
    public static int countOfLaptopsByBrand(Laptop[] lp, String brand) {
        int count = 0;

        for(Laptop l : lp) {
            if(l.getBrand().equalsIgnoreCase(brand) && l.getRating() > 3) {
                count++;
            }
        }

        return count;
    }

    public static Laptop[] searchLaptopByOsType(Laptop[] lp, String osType) {
        List<Laptop> res = new ArrayList<Laptop>();

        for(Laptop l : lp) {
            if(l.getOsType().equalsIgnoreCase(osType)) {
                res.add(l);
            }
        }

        res.sort(new Comparator<Laptop> () {
            @Override
            public int compare(Laptop l1, Laptop l2) {
                return Integer.compare(l2.getLaptopId(), l1.getLaptopId());
            }
        });

        if(res.size() == 0) return null;
        return res.toArray(new Laptop[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Laptop[] LP = new Laptop[4];

        for (int i = 0; i < LP.length; i++) {
            int inputId = sc.nextInt();
            sc.nextLine();
            String inputBrand = sc.nextLine();
            String inputOsType = sc.nextLine();
            double inputPrice = sc.nextDouble();
            sc.nextLine();
            int inputRating = sc.nextInt();
            LP[i] = new Laptop(inputId, inputBrand, inputOsType, inputPrice, inputRating);
        }

        sc.nextLine();
        String paramBrand = sc.nextLine();
        String paramOsType = sc.nextLine();

        int count = countOfLaptopsByBrand(LP, paramBrand);

        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("The given brand is not available");
        }
        Optional<Laptop[]> op = Optional.ofNullable(searchLaptopByOsType(LP, paramOsType));

        if(op.isPresent()) {
            Laptop lp[] = op.get();
            for(int i = 0; i < lp.length; i++) {
                System.out.println(lp[i].getLaptopId());
                System.out.println(lp[i].getRating());
            }
        } else
            System.out.println("The given os is not available"); 
    }
}

/*
--- input ---
123
HP
Windows
35000
5
124
Apple
Mac OS
70000
5
125
Dell
Ubuntu
30000
4
126
Hp
Windows
40000
4
HP
Windows

--- output ---
2
126
4
123
5

*/