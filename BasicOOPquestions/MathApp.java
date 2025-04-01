package pk1;
/*Create a Java class called "MathOperations" with following methods.
Implement a method that takes two integers as input parameters and prints 
the multiplication table for first input parameter up to the second parameter.

public void drawMultiplicationTable (int number, int range):

Implement another method that reads a positive integer (n) from the user and calculates 
the factorial of that number(n!) using a loop and return the value.

public int factorial():

Create another class called "MathApp" with main method and call both the implemented 
methods and display the outputs properly*/

import java.util.Scanner;

//Class containing mathematical operations
class MathOperations {
 // Method to print the multiplication table
 public void drawMultiplicationTable(int number, int range) {
     System.out.println("Multiplication Table for " + number + ":");
     for (int i = 1; i <= range; i++) {
         System.out.println(number + " x " + i + " = " + (number * i));
     }
 }

 // Method to calculate factorial of a number
 public int factorial() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter a positive integer for factorial calculation: ");
     int n = scanner.nextInt();
     int fact = 1;
     
     for (int i = 1; i <= n; i++) {
         fact *= i;
     }
     
     return fact;
 }
}

//Main application class
public class MathApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     MathOperations mathOperations = new MathOperations();
     
     // Calling drawMultiplicationTable method
     System.out.print("Enter the number for multiplication table: ");
     int number = scanner.nextInt();
     System.out.print("Enter the range for multiplication table: ");
     int range = scanner.nextInt();
     mathOperations.drawMultiplicationTable(number, range);
     
     // Calling factorial method
     int result = mathOperations.factorial();
     System.out.println("Factorial: " + result);
     
     scanner.close();
 }
}
/*Output :
Enter the number for multiplication table: 6
Enter the range for multiplication table: 4
Multiplication Table for 6:
6 x 1 = 6
6 x 2 = 12
6 x 3 = 18
6 x 4 = 24
Enter a positive integer for factorial calculation: 5
Factorial: 120 */