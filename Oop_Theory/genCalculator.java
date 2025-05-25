package beforeoopfinal;

import java.util.Scanner;

class Test<X extends Number, Y extends Number> {
    public void printnum(X i, Y f) {
        double result = i.doubleValue() + f.doubleValue(); //doubleValue() is a method of Number class
        System.out.println("Sum: " + result);
    }
}

public class genCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number (int or float): ");
        String input1 = sc.next();

        System.out.print("Enter second number (int or float): ");
        String input2 = sc.next();

        // Try to parse as float (which can also handle ints)
        try {
            if (input1.contains(".") || input2.contains(".")) {
                Float num1 = Float.parseFloat(input1);
                Float num2 = Float.parseFloat(input2);
                Test<Float, Float> t = new Test<>();
                t.printnum(num1, num2);
            } else {
                Integer num1 = Integer.parseInt(input1);
                Integer num2 = Integer.parseInt(input2);
                Test<Integer, Integer> t = new Test<>();
                t.printnum(num1, num2);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        }
    }
}
/*Enter first number (int or float): 5.4
Enter second number (int or float): 7.6
Sum: 13.0*/
