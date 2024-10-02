import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Arrays;

class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return this.hotelId;
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public String getDateOfBooking() {
        return this.dateOfBooking;
    }

    public double getNoOfRoomsBooked() {
        return this.noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return this.wifiFacility;
    }

    public double getTotalBill() {
        return this.totalBill;
    }
}
public class program4 {
    public static int noOfRoomsBookedInGivenMonth(Hotel[] ht, String inputMonth) {
        int count = 0;
        for(Hotel h : ht) {
            String month = h.getDateOfBooking().split("-")[1];
            if(month.equalsIgnoreCase(inputMonth.substring(0,3))) {
                count += h.getNoOfRoomsBooked();
            }
        }

        return count;
    }

    public static Hotel searchHotelByWifiOption(Hotel[] ht, String inputWifiOption) {
        // Hotel[] filteredHotels = Arrays.stream(ht).filter(h -> h.getWifiFacility().equalsIgnoreCase(inputWifiOption)).sorted(new Comparator<Hotel>() {
        //     public int compare(Hotel o1, Hotel o2) { return Double.compare(o2.getTotalBill(), o1.getTotalBill()); };
        // }).toArray(Hotel[]::new);

        // if(filteredHotels.length < 1) return null;
        // if(filteredHotels.length == 1) return filteredHotels[0];
        // return filteredHotels[1];

        List<Hotel> res = new ArrayList<Hotel>();

        for(Hotel h : ht) {
            if(h.getWifiFacility().equalsIgnoreCase(inputWifiOption)) {
                res.add(h);
            }
        }

        double highest = Double.NEGATIVE_INFINITY;
        double secondHighest = Double.NEGATIVE_INFINITY;
        Hotel secondHighestBillHotel = null;
        Hotel highestBillHotel = null;

        for(Hotel h : ht) {
            double totalBill = h.getTotalBill();

            if(totalBill > highest) {
                secondHighest = highest;
                highest = totalBill;
                secondHighestBillHotel = highestBillHotel;
                highestBillHotel = h;
            } else if(totalBill > secondHighest && totalBill < highest) {
                secondHighest = totalBill;
                secondHighestBillHotel = h;
            }
        }

        return secondHighestBillHotel;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] HT = new Hotel[4];

        for (int i = 0; i < HT.length; i++) {
            int inputHotelId = sc.nextInt();
            sc.nextLine();
            String inputHotelName = sc.nextLine();
            String inputDateOfBooking = sc.nextLine();
            int inputNoOfRoomsBooked = sc.nextInt();
            sc.nextLine();
            String inputWifiFacility = sc.nextLine();
            double inputTotalBill = sc.nextDouble();
            HT[i] = new Hotel(inputHotelId, inputHotelName, inputDateOfBooking, inputNoOfRoomsBooked, inputWifiFacility, inputTotalBill);
        }

        sc.nextLine();
        String paramMonth = sc.nextLine();
        String paramWifiOption = sc.nextLine();

        int count = noOfRoomsBookedInGivenMonth(HT, paramMonth);

        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No rooms booked in the given month");
        }
        Optional<Hotel> op = Optional.ofNullable(searchHotelByWifiOption(HT, paramWifiOption));

        if(op.isPresent()) {
            Hotel ht = op.get();
            System.out.println(ht.getHotelId());
        } else
            System.out.println("No such option available"); 
    }
}

/*
--- input ---

101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May
Yes

--- ouput ---
5 
103

*/
