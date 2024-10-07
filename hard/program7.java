/**
Create a class Employee with below attributes:
employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of 
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input 
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of 
Employee objects referring attributes in the above mentioned attribute sequence.
**/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Optional;

class Employee {
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;

    public Employee(int employeeId, String employeeName, int age, char gender, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public int getAge() {
        return this.age;
    }

    public char getGender() {
        return this.gender;
    }

    public double getSalary() {
        return this.salary;
    }
}

public class program7 {
    public static Employee[] getEmployeeWithSecondLowestSalary(Employee[] employees) {
        if(employees.length < 2) return null;

        // Arrays.sort(employees, (emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()));
        // return employees[1];

        double lowestSalary = Double.POSITIVE_INFINITY;
        double secondLowestSalary = Double.POSITIVE_INFINITY;

        for(Employee emp : employees) {
            double curr_salary = emp.getSalary();
            if(curr_salary < lowestSalary) {
                secondLowestSalary = lowestSalary;
                lowestSalary = curr_salary;
            } else if(curr_salary < secondLowestSalary && curr_salary > lowestSalary) {
                secondLowestSalary = curr_salary;
            }
        }

        final double slSal = secondLowestSalary;

        return Arrays.stream(employees).filter(emp -> emp.getSalary() == slSal).toArray(Employee[]::new);
    }

    public static int countEmployeesBasedOnAge(Employee[] employees, int age) {
        int count = 0;

        for(Employee emp : employees) {
            if(emp.getAge() == age) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] emp = new Employee[4];

        for(int i = 0; i < emp.length; i++) {
            int inputEmployeeId = sc.nextInt();
            sc.nextLine();
            String inputEmployeeName = sc.nextLine();
            int inputAge = sc.nextInt();
            sc.nextLine();
            char inputGender = sc.next().charAt(0);
            sc.nextLine();
            double inputSalary = sc.nextDouble();
            sc.nextLine();

            emp[i] = new Employee(inputEmployeeId, inputEmployeeName, inputAge, inputGender, inputSalary);
        }

        int age = sc.nextInt();

        Optional<Employee[]> op = Optional.ofNullable(getEmployeeWithSecondLowestSalary(emp));
        if(op.isPresent()) {
            Employee resEmp[] = op.get();
            for(int i = 0; i < resEmp.length; i++) {
                System.out.println(resEmp[i].getEmployeeId() + " # " + resEmp[i].getEmployeeName());
            }
        } else {
            System.out.println("Null");
        }

        int count = countEmployeesBasedOnAge(emp, age);
        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No employee found for the given age");
        }
    }
}

/* 

--- input ---
100
Rajdip
23
M
10000
101
Sandip
23
M
5000
102
Akash
24
M
23000
103
Rimpa
24
F
25000
23

--- output ---
100 # Rajdip
2

*/