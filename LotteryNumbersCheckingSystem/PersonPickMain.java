package LotteryQuestion;

import java.util.Scanner;

public class PersonPickMain {
    public static void main(String[] args) {
        Lottery lot = new Lottery(); // Create Lottery object
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];

        // Get user's lottery picks
        System.out.println("Enter 5 numbers (0-9) for your lottery picks: ");
        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }
        sc.close(); // Close scanner to prevent resource leaks

        // Display lottery numbers and compare results
        lot.displayLotteryNumbers();
        int matchCount = lot.compare(array);
        System.out.println("Number of Matching Digits: " + matchCount);
    }
}
