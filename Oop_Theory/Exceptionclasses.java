//InvalidPhoneNumberDigits.java
public class InvalidPhoneNumberDigits extends Exception {
    public InvalidPhoneNumberDigits() { //default constructor
        super("The phone number must have exactly 10 digits.");
    }
}
//InvalidPhoneNumberStart.java
public class InvalidPhoneNumberStart extends Exception {
    public InvalidPhoneNumberStart() {
        super("The phone number must start with 0.");
    }
}
//DemoApp.java
import java.util.Scanner;

public class DemoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 10-digit phone number: ");
        String phoneNumber = scanner.nextLine();

        try {
            validatePhoneNumber(phoneNumber);
            System.out.println("Phone number is valid: " + phoneNumber);
        } catch (InvalidPhoneNumberDigits | InvalidPhoneNumberStart e) {
            System.out.println("Validation Error: " + e.getMessage());//InvalidPhoneNumberStart(class) e(object).getMessage(a method of Exceptionclass)
        }

        scanner.close();
    }

    // Method to validate phone number
    public static void validatePhoneNumber(String number) throws InvalidPhoneNumberDigits, InvalidPhoneNumberStart {  //throw if there is any error then catch block will fetch that
        if (number.length() != 10) {
            throw new InvalidPhoneNumberDigits();//calling the exeption constructor. then subclass will load the superclass's constructor and its message inside the subclass. 
        }                                       //loaded message will be get by calling 'e.getMessage'.
        if (!number.startsWith("0")) {
            throw new InvalidPhoneNumberStart();
        }
    }
}
//by doing 'new InvalidPhoneNumberDigits()' we caliing the default constructor automatically. 'throw' is the keyword that returning a error
