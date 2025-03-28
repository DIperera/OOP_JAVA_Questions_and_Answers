package labtestquestions;

import java.util.Scanner;

public class DemoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a phone number: ");
        String pnum = sc.next(); // Get user input

        try {
            validatePhoneNumber(pnum);
            System.out.println("Valid phone number.");
        } catch (InvalidPhoneNumberDigits | InvalidPhoneNumberStart e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close(); // Close Scanner to prevent memory leaks
        }
    }

    // Method to validate phone number
    public static void validatePhoneNumber(String pnumber) throws InvalidPhoneNumberDigits, InvalidPhoneNumberStart {
        if (pnumber.length() != 10) {
            throw new InvalidPhoneNumberDigits("The phone number must have exactly 10 digits.");
        }
        if (pnumber.charAt(0) != '0') {
            throw new InvalidPhoneNumberStart("The phone number must start with 0.");
        }
    }
}

/* 
Output :
1. Invalid Length (Less than 10 digits)

    Enter a phone number: 07123
    Error: The phone number must have exactly 10 digits.

2. Invalid Start (Does not start with '0')

    Enter a phone number: 9123456789
    Error: The phone number must start with 0.

3. Valid Input

    Enter a phone number: 0712345678
    Valid phone number.