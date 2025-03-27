package Ex5;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // Create an object of EvenOddNumber class
        EvenOddNumber n1 = new EvenOddNumber();
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a Number: ");
        int number = sc.nextInt();
        
        // Call the method and store the result
        boolean result = n1.findEvenOrOdd(number);
        
        // Using ternary operator for display
        String status = result ? "Even" : "Odd"; //This is the ternary operator
        System.out.println("The number is: " + status);
        
        sc.close(); // Close scanner to prevent resource leaks
    }
}
