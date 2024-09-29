import java.util.Scanner;
import java.util.Optional;

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private Boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String packageType, int price, Boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRegNo() {
        return this.regNo;
    }

    public String getPackageType() {
        return this.packageType;
    }

    public Boolean getFlightFacility() {
        return this.flightFacility;
    }

    @Override
    public String toString() {
        return "TravelAgencies{regNo = " + this.regNo + ", agencyName = " + this.agencyName + ", packageType = " + this.packageType + ", price = " + this.price + ", flightFacility = " + this.flightFacility + "}";
    }
}

public class program2 {
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] TA) {
        int highestPackagePrice = 0;

        for(TravelAgencies ta : TA) {
            highestPackagePrice = Math.max(highestPackagePrice, ta.getPrice());
        }

        return highestPackagePrice;
    }

    public static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] TA, int regNo, String packageType) {
        for(TravelAgencies ta : TA) {
            if(ta.getFlightFacility() == true && ta.getRegNo() == regNo && ta.getPackageType().equals(packageType))
                return ta;
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] TA = new TravelAgencies[4];

        for (int i = 0; i < TA.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            Boolean e = sc.nextBoolean();
            TA[i] = new TravelAgencies(a, b, c, d, e);
        }

        System.out.println("Agency with highest package price: " + findAgencyWithHighestPackagePrice(TA));

        int inputRegNo = sc.nextInt();
        sc.nextLine();
        String inputPackageType = sc.nextLine();

        Optional<TravelAgencies> op = Optional.ofNullable(agencyDetailsforGivenIdAndType(TA, inputRegNo, inputPackageType));

        if(op.isPresent()) {
            TravelAgencies agency = op.get();
            System.out.println(agency);
            System.out.println("The required agency details\n" + agency.getAgencyName() + " : " + agency.getPrice());
        } else
            System.out.println("No agencies found"); 
            
    }
}

/* 
--- input ---
123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Diamond
40000
true
888
Global Tours
Silver
20000
false

--- ouput ---
Agency with highest package price: 50000
--- input ---
987
Diamond

--- output ---
TravelAgencies@27bc2616
The required agency details
Cox and Kings : 40000
*/