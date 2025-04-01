/*
Create two Java classes named "Employee" and "ParttimeEmployee". 
The Employee class should have two attributes:
- name (String)
- salary (double)

Create a constructor that accepts values for both attributes and a method named "displayInfo()" 
which displays the employee's name and salary.

The ParttimeEmployee class should be extended from the Employee class and should have a specific attribute:
- OTHrs (int)

Create an overloaded constructor that supports the following object creation:
ParttimeEmployee emp1 = new ParttimeEmployee("Alice", 20000.00, 7);

Implement a method called "displayEmpInfo()" to display all the details of a part-time employee, 
including name, salary, and OT hours.

Create a class called "EmpApp" with the main method. Create 2 ParttimeEmployee objects and 
display the details by calling the displayEmpInfo() method.
*/

class Employee {
    protected String name;
    protected double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class ParttimeEmployee extends Employee {
    private int OTHrs;

    // Constructor
    public ParttimeEmployee(String name, double salary, int OTHrs) {
        super(name, salary);
        this.OTHrs = OTHrs;
    }

    // Method to display part-time employee information
    public void displayEmpInfo() {
        displayInfo(); // Calling parent class method
        System.out.println("OT Hours: " + OTHrs);
    }
}

public class EmpApp {
    public static void main(String[] args) {
        // Creating ParttimeEmployee objects
        ParttimeEmployee emp1 = new ParttimeEmployee("Alice", 20000.00, 7);
        ParttimeEmployee emp2 = new ParttimeEmployee("Bob", 18000.00, 5);

        // Displaying information of employees
        System.out.println("Employee 1 Details:");
        emp1.displayEmpInfo();
        
        System.out.println("\nEmployee 2 Details:");
        emp2.displayEmpInfo();
    }
}
