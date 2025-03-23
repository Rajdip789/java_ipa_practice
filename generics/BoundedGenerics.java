package generics;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    int id;

    Vehicle(int id) {
        this.id = id;
    }

    public void printDetails() {
        System.out.println("Vehicle ID: " + id);
    }
}

class Bus extends Vehicle {
    Bus(int id) {
        super(id);
    }
}

class Car extends Vehicle {
    Car(int id) {
        super(id);
    }
}

class Print {

    // Upper bound wildcard
    public void setPrintValue1(List<? extends Vehicle> v) {
        for (Vehicle vehicle : v) {
            vehicle.printDetails();
        }
    }

    // Lower bound wildcard
    public void setPrintValue2(List<? super Bus> v) {
        for (Object obj : v) {
            if(obj instanceof Vehicle)
                ((Vehicle) obj).printDetails();
        }
    }

    // Unbounded wilcard
    public void setPrintValue3(List<?> v) {
        for (Object obj : v) {
            if(obj instanceof Vehicle)
                ((Vehicle) obj).printDetails();
        }
    }
}

public class BoundedGenerics {
    public static void main(String[] args) {
        List<Vehicle> vList = new ArrayList<>();
        vList.add(new Vehicle(1));
        vList.add(new Vehicle(2));

        List<Bus> bList = new ArrayList<>();
        bList.add(new Bus(101));
        bList.add(new Bus(102));

        Print pobj = new Print();

        pobj.setPrintValue1(vList);
        pobj.setPrintValue1(bList);

        pobj.setPrintValue2(vList);
        pobj.setPrintValue2(bList);

        pobj.setPrintValue3(vList);
        pobj.setPrintValue3(bList);
    }
}
