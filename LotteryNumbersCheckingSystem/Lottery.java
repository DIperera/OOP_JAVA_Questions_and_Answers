package LotteryQuestion;

import java.util.Random;
import java.util.ArrayList;

public class Lottery {
    private int[] lotnums = new int[5];

    // Constructor to generate random lottery numbers
    public Lottery() {
        Random ran = new Random();
        for (int i = 0; i < lotnums.length; i++) {
            lotnums[i] = ran.nextInt(10); // Generates numbers from 0 to 9
        }
    }

    // Method to compare user's picks with lottery numbers
    public int compare(int[] picksArray) {
        int matchCount = 0;
        ArrayList<Integer> matchingNumbers = new ArrayList<>();

        for (int i = 0; i < lotnums.length; i++) {
            if (lotnums[i] == picksArray[i]) {
                matchingNumbers.add(lotnums[i]);
                matchCount++;
            }
        }

        System.out.print("Matching Numbers: ");
        if (matchingNumbers.isEmpty()) {
            System.out.println("None");
        } else {
            for (int num : matchingNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        return matchCount;
    }

    // Method to display lottery numbers
    public void displayLotteryNumbers() {
        System.out.print("Lottery Numbers: ");
        for (int num : lotnums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
