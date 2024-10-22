/*

Create a class Institution with below attributes:

InstitutionId - int
institutionName - String
noOfStudensPlaced - int
noOfStudentsCleared - int
location - String
grade - String

Write getters, setters for the above attributes.
Create constructor which takes prameter in the above sequence except grade

Create class Solution with main method. Implement two static methods - 
findNumClearancedByLoc
updateInstituionGrade

findNumClearancedByLoc method:
This method will take two input parameters - array of Instituion objects and string parameter location.
The method will return the sum of the noOfStudentsCleared attribute from instituion objects for the location 
passed as paramter. If no instituion with the given location is present in the array of institution objects, then the method should return 0.

updateInstituionGrade method:
This method will take a String parameter institutionName, along with the array of Instituioni objects. 
The method will return the institution object, if the input String parameter matches with the instutionName attribute 
of the institution object. Before returning the object, the grade should be arrived based on the rating calculation mentioned below. 
This grade value should be assigned to the object. If any of the above conditions are not met, then the method should return null.

The grade attribute should be calculated as follows: rating=(noOfStudentsPlaced * 100)/noOfStudentsCleared 
If the rating&gt = 80 , then grade should be 'A'. Else, then grade should be 'B'

Note: No institution object would have the same value for institutionName attribute. 
All institution object would have the noOfStudentsPlaced value lesser than noOfStudentsCleared value. 
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findNumClearancedByLoc method - The main method should print the noOfClearance as it is, if the returned value is greater than 0,
                                     or it should print "There are no cleared students in this particular location".

For updateInstitutionGrade method - The main method should print the institutionName and grade of the returned Institution object. 
                                    The instituationName and grade should be concatinated with :: while printing. 
                                    eg:- TCS::A, where TCS is the institution name and A is the grade. 
                                    If the returned value is null then it should print "No Institute is available with the specified name".

Before calling these static methods in main, use Scanner object to read the values of four Institution objects referring attributes 
in the above mentioned attribute sequence (except grade attribute). Next, read the value for location and institutionName.

*/

import java.util.Scanner;
import java.util.Optional;

class Instituion {
    private int institutionId;
    private String institutionName; 
    private int noOfStudensPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Instituion(int institutionId, String institutionName, int noOfStudensPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudensPlaced = noOfStudensPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }

    String getInstitutionName() {
        return this.institutionName;
    }

    int getNoOfStudentsPlaced() {
        return this.noOfStudensPlaced;
    }

    int getNoOfStudentsCleared() {
        return this.noOfStudentsCleared;
    }

    String getLocation() {
        return this.location;
    }

    String getGrade() {
        return this.grade;    
    }

    void setGrade(String grade) {
        this.grade = grade;
    }
}

public class program9 {
    public static int findNumClearancedByLoc(Instituion[] instituions, String location) {
        int noOfStudentsClearedByLoc = 0;
        
        for(Instituion ins : instituions) {
            if(ins.getLocation().equalsIgnoreCase(location)) {
                noOfStudentsClearedByLoc += ins.getNoOfStudentsCleared();
            }
        }

        return noOfStudentsClearedByLoc;
    }

    public static Instituion updateInstituionGrade(Instituion[] instituions, String insName) {
        for(Instituion ins : instituions) {
            if(ins.getInstitutionName().equalsIgnoreCase(insName)) {
                int rating = (ins.getNoOfStudentsPlaced() * 100) / ins.getNoOfStudentsCleared();

                if(rating >= 80) {
                    ins.setGrade("A");
                } else {
                    ins.setGrade("B");
                }

                return ins;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Instituion[] ins = new Instituion[4];

        for(int i = 0; i < ins.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int placed = sc.nextInt();
            sc.nextLine();
            int cleared = sc.nextInt();
            sc.nextLine();
            String location = sc.nextLine(); 

            ins[i] = new Instituion(id, name, placed, cleared, location);
        }

        String loc = sc.nextLine();
        String insName = sc.nextLine();

        int no = findNumClearancedByLoc(ins, loc);

        if(no > 0) {
            System.out.println(no);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        Optional<Instituion> op = Optional.ofNullable(updateInstituionGrade(ins, insName));

        if(op.isPresent()) {
            Instituion res = op.get();
            System.out.println(res.getInstitutionName() + "::" + res.getGrade());
        }
    }
}

/*

--- input ---
111
Amrita
5000
10000
Chennai
222
Karunya
16000
20000
Coimbatore
333
AppleTech
10000
12000
Chennai
444
Aruna
6000
10000
Vellore
Chennai
Karunya

--- output ---
22000
Karunya::A

*/